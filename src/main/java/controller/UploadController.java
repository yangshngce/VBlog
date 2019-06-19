package controller;

import common.VideoFrameKit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import model.FileEntity;
import common.Upload;
import po.VideoPo;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false) MultipartFile multipartFile, HttpServletRequest request, ModelMap map) {
            String message = "";
        FileEntity entity = new FileEntity();
        Upload fileUploadTool = new Upload();
        String videoPath="WEB-INF/statics/videos";
        String savePath= "WEB-INF/statics/videos/videoImages";
        VideoFrameKit videoFrameKit = new VideoFrameKit();

//JSONObject getObj = new JSONObject();  
        try {
            entity = fileUploadTool.createFile(multipartFile, request);
            if(entity != null){
                //service.saveFile(entity);
                message = "上传成功";
                map.put("entity", entity);
                map.put("result", message);
                videoFrameKit.fetchFrame(videoPath,savePath);

            }else{
                message = "上传失败";
                map.put("result", message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
