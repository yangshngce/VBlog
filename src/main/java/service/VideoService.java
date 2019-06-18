package service;

import po.VideoPo;
import web.VideoForm;

import java.util.List;

public interface VideoService {
    Integer upLoadVideo(VideoForm videoForm);
    List<VideoPo> downLoadVideo(Integer usrId);
}
