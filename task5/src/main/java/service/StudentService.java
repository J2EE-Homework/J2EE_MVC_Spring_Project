package service;

import dao.StudentDAO;
import model.Student;
import servletImp.ServiceInter;

import java.util.Iterator;
import java.util.List;
/**
 * Created by JuN on 16/10/20.
 */

/**
 * this is service to change jsp
 *
 * @authorJuN
 * @create2016-10-20 16:03
 */
public class StudentService implements ServiceInter {

    private StudentDAO dao ;

    public StudentService() {
        dao = new StudentDAO() ;
    }

    public StudentService(String nothing){
        // do nothing
        dao = new StudentDAO(nothing);
    }


    public int add(Student student) {
        return dao.add(student);
    }

    public int hibernateAdd(Student student){
        return dao.hibernateAdd(student);
    }


    public int delete(int id) {
        return dao.delete(id);
    }

    public int hibernateDelete(int id){
        return dao.hibernateDelete(id);
    }


    public int modify(Student student) {
        return dao.modify(student);
    }

    public int hibernateModify(Student student){
        return dao.hibernateModify(student);
    }

    public List<?> list() {
        return dao.list();
    }

    public List<?> hibernateList(){
        return dao.hibernateList();
    }


    //成功返回1，密码错误返回－1，没有这个用户返回－2
    public int login(Student student) {
        List<Student> studentList = dao.list();
        if (studentList == null){
            return -2;
        }
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()){
            Student stu = iterator.next();
            if (student.getName().equals(stu.getName())){
                if (student.getPassword().equals(stu.getPassword())){
                    //登陆成功
                    return 1;
                }else {
                    //密码错误
                    return -1;
                }
            }
        }

        //没有这个用户
        return -2;

    }

    public int hibernateLogin(Student student){
        //System.out.println("----------hibernateLogin");
        List<Student> studentList = dao.hibernateList();
        if (studentList == null){
            System.out.println("数据获取失败");
            return -2 ;
        }
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()){
            Student stu = iterator.next();
            //System.out.println(stu.getName());
            if (student.getName().equals(stu.getName())){
                if (student.getPassword().equals(stu.getPassword())){
                    //登录成功
                    return 1;
                }else {
                    //密码错误
                    return -1;
                }
            }
        }
        return -2;
    }

    //注册成功返回1，注册失败(用户已存在返回)0,其他错误返回-1
    public int register(Student student) {

        List<Student> studentList = dao.list();
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()){
            Student stu = iterator.next();

            if (student.getName().equals(stu.getName())){
                return 0;
            }
        }
        //插入数据 1成功插入 －1插入失败
        return dao.add(student);
    }

    public int hibernateRegister(Student student) {
        List<Student> studentList = dao.hibernateList();
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()){
            Student stu = iterator.next();
            if (student.getName().equals(stu.getName())){
                return 0;
            }
        }
        //插入数据，1成功插入 －1插入失败
        return dao.hibernateAdd(student);
    }
}
