package mapper;

import org.apache.ibatis.annotations.*;
import po.UserPo;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<UserPo> selectAll();

    @Select("select * from user where NAME = '${name}'")
    UserPo judgeUser(@Param("name") String name);

    @Insert("insert into user (NAME,PASSWORD,HOME_ID)values(#{NAME},#{PASSWORD},#{HOME_ID})")
    Integer addUser(UserPo userPo);

    @Update("update user set PASSWORD = '${PASSWORD}' where NAME = '${NAME}'")
    Integer update(UserPo userPo);
}
