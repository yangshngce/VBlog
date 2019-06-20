package controller;

import bo.CommentBo;
import bo.VideoImageBo;
import model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CommentService;
import web.LoginForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/commentTest")
    @ResponseBody
    public List<CommentBo> commentTest(String videoName,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("进入commentTest："+videoName);
        return commentService.getComment(videoName);
    }


}
