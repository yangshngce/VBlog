package pojo;

import java.util.Date;

public class Users {
    String name;
    String password;
    String sex;
    int age;
    String date;
    int soccer;
    int usertype;
    String email;

    public Users(String name, String password, String sex, int age, String date, int soccer, int usertype, String email) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.date = date;
        this.soccer = soccer;
        this.usertype = usertype;
        this.email = email;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSoccer() {
        return soccer;
    }

    public void setSoccer(int soccer) {
        this.soccer = soccer;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", date='" + date + '\'' +
                ", soccer=" + soccer +
                ", usertype=" + usertype +
                ", email='" + email + '\'' +
                '}';
    }
}
