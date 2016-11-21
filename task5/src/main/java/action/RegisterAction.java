package action;/**
 * Created by JuN on 16/11/20.
 */

import com.opensymphony.xwork2.ActionSupport;
import model.Student;
import service.StudentService;

/**
 * register action class
 *
 * @authorJuN
 * @create2016-11-20 11:34
 */
public class RegisterAction extends ActionSupport {

    private String register_name ;

    private String register_password ;

    private String register_password2 ;

    private StudentService service ;

    public RegisterAction() {
        service = new StudentService();
    }

    public String getRegister_name() {
        return register_name;
    }

    public void setRegister_name(String register_name) {
        this.register_name = register_name;
    }

    public String getRegister_password() {
        return register_password;
    }

    public void setRegister_password(String register_password) {
        this.register_password = register_password;
    }

    public String getRegister_password2() {
        return register_password2;
    }

    public void setRegister_password2(String register_password2) {
        this.register_password2 = register_password2;
    }


    //execute
    public String execute() throws Exception{
        //判断是否注册成功
        Student student = new Student(register_name,register_password);
        //System.out.println("-----------------");
        switch (service.hibernateRegister(student)){
            case 1:
                //注册成功
                //System.out.println("success--------");
                return "success";
            case 0:
                //注册失败，用户已存在
                //System.out.println("failed--------");
                return "failed";
            case -1:
                //操作失败
                //System.out.println("error--------");
                return "error";
            default:
                return "input";
        }
    }
}
