package service;

import bo.VideoImageBo;
import po.VideoPo;
import web.VideoForm;

import java.util.List;

public interface VideoService {
    Integer upLoadVideo(VideoForm videoForm);
    List<VideoPo> downLoadVideo(Integer usrId);
    List<VideoPo> getVideoByType(String type);
    List<VideoImageBo> selAll();
    VideoPo playVideo(String videoName);
}
