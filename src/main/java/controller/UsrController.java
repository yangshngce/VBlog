package controller;

import model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UsrService;
import web.LoginForm;
import web.RegisterForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UsrController {

    @Autowired
    private UsrService usrService;

    @RequestMapping(value = "/usr",method = RequestMethod.GET)
    @ResponseBody
    public Result login(LoginForm loginForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println("接收到前端发来的信息");
        System.out.println(loginForm);

        Integer temp=usrService.loginJudge(loginForm);
        switch(temp){
            case 1:
                httpServletRequest.getSession().setAttribute("loginUsr",loginForm);
                return new Result(true,1001+"","密码正确，登陆成功",null);
            case 2:
                return new Result(true,1002+"","密码错误，登陆失败",null);
            case 3:
                return new Result(true,1003+"","用户名错误",null);
            default:
                return new Result(false,1004+"","查询失败",null);
        }
    }

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

    @RequestMapping(value = "/usr",method = RequestMethod.POST)
    @ResponseBody
    public Result register(RegisterForm registerForm){
        Integer temp=usrService.register(registerForm);
        System.out.println("temp:"+temp);
        switch(temp){
            case 0:
                return new Result(true,"2000","注册失败",null);
            case 1:
                return new Result(true,"2001","注册成功",null);
            case 2:
                return new Result(true,"2002","注册失败，用户已存在",null);
            default:
                return new Result(false,"2003","查询失败",null);
        }
    }
}
