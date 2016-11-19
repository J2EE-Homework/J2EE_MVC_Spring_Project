package studentTest;/**
 * Created by JuN on 16/10/13.
 */

import com.opensymphony.xwork2.interceptor.annotations.Before;
import dao.StudentDAO;
import model.Student;
import org.junit.Assert;
import org.junit.Test;
import untity.DBUtil;

import java.sql.Connection;
import java.util.List;

/**
 * this is a test for student
 *
 * @authorJuN
 * @create2016-10-13 16:18
 */
public class studentTest {

    private final StudentDAO studentDAO;

    public studentTest() {
        studentDAO = new StudentDAO();
    }

    @Before
    public void init() throws Exception{

    }

    @Test
    public void getConnectionTest() throws Exception{
        DBUtil util = new DBUtil();
        Assert.assertNotNull(util.getConnection());
    }

    @Test
    public void getConnectionWithParamsTest() throws Exception{
        DBUtil util = new DBUtil();
        Assert.assertNotNull(
                util.getConnection("jdbc:mysql://localhost:3306/data","root","123456")
        );
    }

    @Test
    public void openConnectionTest() throws Exception{
        DBUtil util = new DBUtil();
        Assert.assertNotNull(util.openConnection());
    }

    @Test
    public void addStudentTest() throws Exception{
        int result = studentDAO.add(new Student("john","123"));
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteStudentTest() throws Exception{
        int result = studentDAO.delete(1);
        Assert.assertEquals(1,result);
    }

    @Test
    public void modifyStudentTest() throws Exception{
        int result = studentDAO.modify(new Student("mike","yyy"));
        Assert.assertEquals(1,result);
    }

    @Test
    public void queryStudentsTest() throws Exception{
        List<Student> result = studentDAO.list();
        Assert.assertNotNull(result);
    }

    @Test
    public void closeConnectionTest() throws Exception{
         DBUtil util = new DBUtil();
         Connection connection = util.getConnection();
         Assert.assertEquals(1,util.closeConnection(connection));
    }

}
