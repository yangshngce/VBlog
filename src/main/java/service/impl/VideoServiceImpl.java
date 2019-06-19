package service.impl;

import bo.VideoImageBo;
import mapper.UserMapper;
import mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.VideoPo;
import service.VideoService;
import web.VideoForm;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private VideoPo videoPo;
    @Autowired
    private List<VideoImageBo> videoImageBos;

    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer upLoadVideo(VideoForm videoForm) {
        videoPo.setVIDEO_NAME(videoForm.getVIDEO_NAME());
        videoPo.setCREATE_TIME(LocalDateTime.now().toString());
        videoPo.setUPLOAD_USR(videoForm.getUPLOAD_USR());
        videoPo.setTYPE(videoForm.getTYPE());
        videoPo.setRANK(videoForm.getRANK());
        videoPo.setLABLE(videoForm.getLABLE());
        videoPo.setIMAGE_URL(videoForm.getIMG_URL());
        videoPo.setURL(videoForm.getURL());
        Integer count=videoMapper.addVideo(videoPo);
        return count>0?1:0;
    }

    @Override
    public List<VideoPo> downLoadVideo(Integer usrId) {
        return videoMapper.selOnesAll(usrId);
    }

    @Override
    public List<VideoPo> getVideoByType(String type) {
        return videoMapper.getVideoByType(type);
    }
    @Override
    public List<VideoImageBo> selAll(){
        videoImageBos.clear();
        List<VideoPo> videoPos= videoMapper.selAll();
        for (VideoPo videoPo:videoPos
             ) {
            VideoImageBo videoImageBo = new VideoImageBo();
            videoImageBo.setVideoName(videoPo.getVIDEO_NAME());
            videoImageBo.setImageUrl(videoPo.getIMAGE_URL());
            videoImageBo.setCreateTime(videoPo.getCREATE_TIME());
            videoImageBo.setUploadUsr(userMapper.getUsrNameById(videoPo.getUPLOAD_USR()));
            videoImageBos.add(videoImageBo);
        }
        return videoImageBos;
    }

    @Override
    public String playVideo(VideoImageBo videoImageBo) {
        return videoMapper.playVideo(videoImageBo.getVideoName());
    }



}
