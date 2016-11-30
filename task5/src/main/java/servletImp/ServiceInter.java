package servletImp;

import model.Student;

import java.util.List;

/**
 * Created by JuN on 16/10/20.
 */
public interface ServiceInter {
    //操作jsp页面的接口，service中的java类必须实现这些接口抽象方法
//    public abstract int add(Student student);

//    public abstract int delete(int id);

    public abstract int hibernateAdd(Student student);

    public abstract int hibernateDelete(int id);

//    public abstract int modify(Student student);

    public abstract int hibernateModify(Student student);

//    public abstract List<?> list();

    public abstract List<?> hibernateList();

//    public abstract int login(Student student);

//    public abstract int register(Student student);

    public abstract int hibernateLogin(Student student);

    public abstract int hibernateRegister(Student student);
}
