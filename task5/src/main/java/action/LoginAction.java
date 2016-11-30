package action;/**
 * Created by JuN on 16/11/10.
 */

import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.StudentService;
import servletImp.ServiceInter;

/**
 * login action in struts2
 *
 * @authorJuN
 * @create2016-11-10 20:16
 */
public class LoginAction{

    private String account ;

    private String password ;

    //接口，解耦合不宜选用具体实现类
    private ServiceInter serviceImp ;

    public ServiceInter getServiceImp() {
        return serviceImp;
    }

    public void setServiceImp(ServiceInter serviceImp) {
        System.out.println("属性注入－－－－－－－－－－");
        this.serviceImp = serviceImp;
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

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        serviceImp = (ServiceInter) context.getBean("serviceImp");

        //System.out.println("------------------");

        switch (serviceImp.hibernateLogin(student)){
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
