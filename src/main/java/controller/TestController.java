package controller;

import bo.CommentBo;
import bo.VideoImageBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/sessionTest")
    @ResponseBody
    public String sessionTest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("session测试");
        if (httpServletRequest.getSession().getAttribute("loginUsr")!=null){
            return httpServletRequest.getSession().getAttribute("loginUsr").toString();
        }else {
            return "00000";
        }
    }

    @RequestMapping(value = "/commentTest")
    @ResponseBody
    public List<CommentBo> commentTest(String videoId){
        return commentService.getComment(Integer.valueOf(videoId));
    }


    @RequestMapping(value = "/mainLoadData")
    @ResponseBody
    public List<VideoImageBo> videoImageBoList(){

    }
}
