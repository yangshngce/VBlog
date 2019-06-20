package controller;

import bo.VideoImageBo;
import common.VideoStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.VideoPo;
import service.UsrService;
import service.VideoService;

import java.util.List;

@Controller
public class VIdeoControlloer {

    @Autowired
    private UsrService usrService;

        @Autowired
        private VideoService videoService;
        @Autowired

        @RequestMapping(value = "mainLoadData")
        @ResponseBody
        public List<VideoImageBo> videoImageBoList(){
             return videoService.selAll();
        }

        @RequestMapping(value = "/play")
        @ResponseBody
        public VideoImageBo playVideo(){
            System.out.println("进入/play");
            VideoImageBo videoImageBo=new VideoImageBo();
            //System.out.println("从videoStore中取出："+VideoStore.videoStack.peek());
            //VideoPo videoPo=videoService.playVideo(VideoStore.videoStack.pop());
            System.out.println("VideoStore.videoName2:"+VideoStore.videoName);
            VideoPo videoPo=videoService.playVideo(VideoStore.videoName);
            System.out.println("videoPo:"+videoPo);
            videoImageBo.setVideoName(videoPo.getVIDEO_NAME());
            videoImageBo.setCreateTime(videoPo.getCREATE_TIME());
            videoImageBo.setImageUrl(videoPo.getIMAGE_URL());
            videoImageBo.setUploadUsr(usrService.getUsrNameById(videoPo.getUPLOAD_USR()));
            System.out.println("playVideo 返回 bo:"+videoImageBo);
            return videoImageBo;
        }

    @RequestMapping(value = "/playVideo")
    @ResponseBody
    public void playVideo(String videoName){
        System.out.println("videoPlay:"+videoName);
        VideoStore.videoName=videoName;
        System.out.println("VideoStore.videoName1:"+VideoStore.videoName);
        //VideoStore.videoStack.push(videoName);
        //System.out.println("stack:"+VideoStore.videoStack.toString());
        //System.out.println("添加到videoStore："+VideoStore.videoStack.peek());
    }

}
