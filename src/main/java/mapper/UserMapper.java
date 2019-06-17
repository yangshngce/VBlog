package mapper;

import org.apache.ibatis.annotations.*;
import po.UserPo;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<UserPo> selectAll();

    @Select("select * from usr where USR_NAME = '${name}'")
    UserPo judgeUser(@Param("name") String name);

    @Insert("insert into usr (USR_NAME,USR_PWD,SEX,AGE,CREATE_TIME,SOCCER,USR_TYPE,EMAIL)values" +
            "(#{USR_NAME},#{USR_PWD},#{SEX},#{AGE},#{CREATE_TIME},#{SOCCER},#{USR_TYPE},#{EMAIL})")
    Integer addUser(UserPo userPo);

    @Update("update user set PASSWORD = '${PASSWORD}' where NAME = '${NAME}'")
    Integer update(UserPo userPo);
}
