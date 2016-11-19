package model;/**
 * Created by JuN on 16/10/8.
 */

/**
 * entity
 *
 * @authorJuN
 * @create2016-10-08 16:30
 */
public class Student {
    String name ;
    String password ;

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
