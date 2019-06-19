package controller;

import common.Upload;
import common.VideoFrameKit;
import model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import model.FileEntity;
import po.VideoPo;
import service.VideoService;
import web.UrlForm;
import web.VideoForm;

@Controller
public class UploadController {
    @Autowired
    VideoService videoService;
    @RequestMapping("/upload")
    @ResponseBody
    public UrlForm upload(@RequestParam(value = "file", required = false) MultipartFile multipartFile, HttpServletRequest request, ModelMap map) {
            String message = "";
        FileEntity entity = new FileEntity();
        Upload fileUploadTool = new Upload();
        UrlForm urlForm = new UrlForm();


//JSONObject getObj = new JSONObject();  
        try {
            entity = fileUploadTool.createFile(multipartFile, request);
            if(entity != null){
                //service.saveFile(entity);
                message = "上传成功";
                map.put("entity", entity);
                map.put("result", message);
                System.out.println(entity.getVideoPath()+entity.getImgPath());
                VideoFrameKit.fetchFrame(entity.getVideoPath(),entity.getImgPath());
                urlForm.setVideoPath(entity.getVideoPath());
                urlForm.setImgPath(entity.getImgPath());
            }else{
                message = "上传失败";
                map.put("result", message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlForm;
    }
    @RequestMapping(value = "/addmsg")
    @ResponseBody
    public Integer addmsg(VideoForm videoForm){
        return videoService.upLoadVideo(videoForm);

    }

}
