package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class addVideo {
    @RequestMapping("/addVideo")
    public String addVideo(@RequestParam(value = "file", required = false) MultipartFile file, VideoInfo videoInfo,
                           HttpServletRequest req, HttpServletResponse res) {//这里的required=false,意思是不传参也可以
        try {
            // 获取当前上下文
            String path = req.getSession().getServletContext().getRealPath("/static/imgs");
            // 文件名称
            String newName = System.currentTimeMillis() + ".png";
            File targetFile = new File(path, newName);
            // 文件夹不存在,则创建文件夹
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            // 保存
            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                log.error(e);
            }
            videoInfo.setVideoUrl(newName);
            videoInfoService.addVideoInfo(videoInfo);
            req.setAttribute("result", "封面上传成功!");
            return "redirect:/videoManag";
        } catch (Exception e) {
            log.error(e);
            req.setAttribute("result", "上传失败!");
            return LOCAVIDEO;
        }

    }
}
