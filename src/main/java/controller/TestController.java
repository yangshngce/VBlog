package controller;

import bo.CommentBo;
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

    @RequestMapping(value = "/sessionTest")
    @ResponseBody
    public Result sessionTest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("session测试");
        if (httpServletRequest.getSession().getAttribute("loginUsr")!=null){
            LoginForm loginForm=(LoginForm)httpServletRequest.getSession().getAttribute("loginUsr");
            loginForm.setPassword("******");
            return new Result(true,3001+"","session包含用户",loginForm);
        }else {
            return new Result(true,3000+"","session为空",null);
        }
    }

    @RequestMapping(value = "/commentTest")
    @ResponseBody
    public List<CommentBo> commentTest(String videoId){
        return commentService.getComment(Integer.valueOf(videoId));
    }
}
