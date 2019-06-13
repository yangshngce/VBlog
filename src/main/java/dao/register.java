package dao;

import java.util.List;
import  pojo.Users;
import  org.apache.ibatis.annotations.Insert;

public interface register {
    @Insert("insert   ")
    List<Users> insertAll();
}
