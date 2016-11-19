package servletImp;

import model.Student;

import java.util.List;

/**
 * Created by JuN on 16/10/20.
 */
public interface ServiceInter {
    //操作jsp页面的接口，service中的java类必须实现这些接口抽象方法
    public abstract int add(Student student);

    public abstract int delete(int id);

    public abstract int modify(Student student);

    public abstract List<?> list();

    public abstract int login(Student student);
}
