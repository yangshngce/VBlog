package controller;

import common.Upload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import model.FileEntity;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false) MultipartFile multipartFile, HttpServletRequest request, ModelMap map) {
            String message = "";
        FileEntity entity = new FileEntity();
        //Upload fileUploadTool = new Upload();


//JSONObject getObj = new JSONObject();  
        try {
            //entity = fileUploadTool.createFile(multipartFile, request);
            if(entity != null){
                //service.saveFile(entity);
                message = "上传成功";
                map.put("entity", entity);
                map.put("result", message);
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
