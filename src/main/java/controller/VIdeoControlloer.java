package controller;

import bo.VideoImageBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.VideoService;

import java.util.List;

@Controller
public class VIdeoControlloer {


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
        public String playVideo(VideoImageBo videoImageBo){
            return videoService.playVideo(videoImageBo);
        }

    }
