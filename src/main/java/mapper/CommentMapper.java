package mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import po.CommentPo;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from res_comment where VIDEO_ID = #{videoId}")
    List<CommentPo> getComment(@Param("videoId") Integer videoId);
}
