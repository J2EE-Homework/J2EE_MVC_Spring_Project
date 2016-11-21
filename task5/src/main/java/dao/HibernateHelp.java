package dao;/**
 * Created by JuN on 16/11/21.
 */

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Hibernate Helper class
 *
 * @authorJuN
 * @create2016-11-21 10:40
 */
public class HibernateHelp {

    public static Session load(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        return session;
    }

    public static void closeSession(Session session){
        session.close();
    }

    public static int saveWithSession(Student student,Session session){
        try {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("插入数据失败");
            session.close();
            return -1;
        }
        session.close();
        return 1 ;
    }

    public static int deleteWithSession(int id,Session session){
        Student student = null;
        try {
            student = (Student) session.get(Student.class,id);
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return -1;
        }
        if (student != null){
            //delete
            Transaction transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
            session.close();
            return 1;
        }
        session.close();
        return -1;
    }

    public static int modifyWithSession(Student student,Session session){
        Student stu = (Student) session.get(Student.class,student.getId());
        if (stu != null){
            //modify
            stu.setName(student.getName());
            stu.setPassword(student.getPassword());
            Transaction transaction = session.beginTransaction();
            try {
                session.update(stu);
            } catch (Exception e) {
                System.out.println("数据更新失败");
                session.close();
                return -1;
            }
            transaction.commit();
            session.close();
            return 1;

        }
        session.close();
        return -1;
    }

    public static List<Student> listWithSession(Session session){
        List<Student> list = new ArrayList<Student>();
        String hql = "from Student";
        Query query = session.createQuery(hql);
        List<Student> li = query.list();
        for (int i = 0 ;i < li.size() ;i++){
            Student student = new Student(li.get(i).getName(),li.get(i).getPassword());
            list.add(student);
        }
        session.close();
        return list;
    }
}
