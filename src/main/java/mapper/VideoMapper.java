package mapper;

import bo.VideoImageBo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import po.VideoPo;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select("select * from res_video;")
    List<VideoPo> selAll();

    @Select("select * from res_video when UPLOAD_USR = #{usrId}")
    List<VideoPo> selOnesAll(@Param("usrId")Integer usrId);

    @Insert("insert into res_video (VIDEO_NAME,CREATE_TIME,UPLOAD_USR,TYPE,RANK,LABLE,URL)" +
            "values('${VIDEO_NAME}','${CREATE_TIME}','${UPLOAD_USR}','${TYPE}','${RANK}','${LABLE}','${URL}');")
    Integer addVideo(VideoPo videoPo);

    @Select("select * from res_video where TYPE = '${type}';")
    List<VideoPo> getVideoByType(@Param("type")String type);

    @Select("select * from res_video where VIDEO_NAME = '${videoName}';")
    List<VideoPo> playVideo(@Param("videoName")String videoName);
}
