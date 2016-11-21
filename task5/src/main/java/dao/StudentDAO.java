package dao; /**
 * Created by JuN on 16/10/8.
 */

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import untity.DBUtil;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO
 *
 * @authorJuN
 * @create2016-10-08 16:26
 */
public class StudentDAO {

    private Connection connection;

    public StudentDAO(String url, String userName, String passWord) {
//       调用加载驱动
       DBUtil util = new DBUtil();
//        建立连接
       connection = util.getConnection(url,userName,passWord);
    }


    public StudentDAO(){
        //利用properties资源连接数据库
        DBUtil util = new DBUtil();

        connection = util.openConnection();
    }

    public StudentDAO(String nothing){
        // do nothing
    }

    //成功返回1，失败返回－1
    public int add(Student student){

        String sql = "INSERT INTO Student (name,password) VALUES ("
                    +"'"+student.getName()+"',"
                    +"'"+student.getPassword()+"'"
                    +")";

        return executeUpdateStatement(sql);
   }

   // Hibernate add
    public int hibernateAdd(Student student){
        int resultCode = 0 ;
        Session session = HibernateHelp.load();
        //save
        resultCode = HibernateHelp.saveWithSession(student,session);

        return resultCode ;
    }

   public int delete(int id){

        String sql = "DELETE FROM Student WHERE id="+id;

        return executeUpdateStatement(sql);
   }
   //Hibernate delete
    public int hibernateDelete(int id){
        int resultCode = 0 ;

        Session session = HibernateHelp.load();
        //delete
        resultCode = HibernateHelp.deleteWithSession(id,session);

        return resultCode ;
    }

   public int modify(Student student){

       String sql = "UPDATE Student SET name='"
               +student.getName()+"',password='"
               +student.getPassword()+"' WHERE name="
               +student.getName();
       return executeUpdateStatement(sql);
   }
   //Hibernate modify
    public int hibernateModify(Student student){
        int resultCode = 0 ;
        Session session = HibernateHelp.load();

        //modify
       resultCode = HibernateHelp.modifyWithSession(student,session);

       return resultCode ;
    }
   //成功返回对象集合，失败返回null
   public List<Student> list(){

       List<Student> students = new ArrayList<Student>();
       String sql = "SELECT * FROM Student";

       try {
           Statement statement = connection.createStatement();
           ResultSet set = statement.executeQuery(sql);
           while (set.next()){
               students.add(
                       new Student(set.getString("name"), set.getString("password"))
               );
           }
           statement.close();
       } catch (SQLException e) {
           System.out.println("数据库查询失败");
           e.printStackTrace();
           return null;
       }
       return students;
   }
   //Hibernate list
   public List<Student> hibernateList(){
        Session session = HibernateHelp.load();
        //list
        List<Student> list = HibernateHelp.listWithSession(session);

        return list ;
    }

   private int executeUpdateStatement(String sql){
       try {
           Statement statement = connection.createStatement();
           statement.executeUpdate(sql);
           statement.close();
       } catch (SQLException e) {
           System.out.println("数据库操作失败");
           e.printStackTrace();
           return -1;
       }
       return 1;
   }

   public void closeConnection(){
       try {
           connection.close();
       } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("数据库连接关闭失败");
       }
   }

}
