package untity; /**
 * Created by JuN on 16/10/8.
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * this is a class connecting to DB
 *
 * @authorJuN
 * @create2016-10-08 15:42
 */
public class DBUtil {


    public Connection getConnection(){

        String jDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/data";
        String username = "root";
        String password = "123456";

        return createConnection(jDriver,url,username,password);
    }

    public Connection getConnection(String url ,String userName ,String passWord) {


        String jDriver = "com.mysql.jdbc.Driver";

        return createConnection(jDriver,url,userName,passWord);
    }

    public Connection openConnection(){

        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("config/DBConfig.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            System.out.print("读取配置文件失败");
            e.printStackTrace();
        }
        String jDriver = properties.getProperty("jdbc.driver");
        //System.out.print("-----------"+jDriver);
        String url = properties.getProperty("jdbc.url");
        //System.out.println("-----------"+url);
        String userName = properties.getProperty("jdbc.username");
        //System.out.println("-----------"+userName);
        String passWord = properties.getProperty("jdbc.password");
        //System.out.println("-----------"+passWord);

        return createConnection(jDriver,url,userName,passWord);
    }
    //1表示成功，0表示原来连接为空，－1表示连接异常
    public int closeConnection(Connection connection){
        if (connection == null){
            return 0;
        }
        try {
            connection.close();
            return 1;
        } catch (SQLException e) {
            System.out.println("数据库关闭异常");
            e.printStackTrace();
            return -1;
        }
    }


    private Connection createConnection(String className,String url,String name,String password){
        Connection connection = null;
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动加载失败");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        return connection ;
    }
}
