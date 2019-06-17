package dao;

import java.util.List;

import org.springframework.stereotype.Component;
import  pojo.Users;
import  org.apache.ibatis.annotations.Insert;

@Component
public interface register {
    public void insertUser(Users users);
    public void update(Users users);
    public void delete(Users users);
}
