package dao;

import java.util.List;
import  pojo.Users;
import  org.apache.ibatis.annotations.Insert;

public interface register {
    public void insertUser(Users users);
    public void update(Users users);
    public void delete(Users users);
}
