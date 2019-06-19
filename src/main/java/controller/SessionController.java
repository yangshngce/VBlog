package controller;

import model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.LoginForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SessionController {
    @RequestMapping(value = "/session")
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

    @RequestMapping(value = "/sessionDelete")
    @ResponseBody
    public Result sessionDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("session测试");
        httpServletRequest.getSession().removeAttribute("loginUsr");
        return new Result(true,3002+"","session移除用户",null);
    }
}
