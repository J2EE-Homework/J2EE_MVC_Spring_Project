package action;/**
 * Created by JuN on 16/11/10.
 */

import model.Student;
import service.StudentService;

/**
 * login action in struts2
 *
 * @authorJuN
 * @create2016-11-10 20:16
 */
public class LoginAction{

    private String account ;

    private String password ;

    private StudentService service ;

    public LoginAction() {
        service = new StudentService("nothing");
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //execute
    public String execute() throws Exception{
        //判断登录成功与否
        Student student = new Student(account,password);

        //System.out.println("------------------");

        switch (service.hibernateLogin(student)){
            case 1:
                // 登录成功
                return "success";
            case -1:
                //密码错误
                return "failed";
            case -2:
                //没有这样的用户
                return "null";
            default:
                return "error";
        }
    }
}
