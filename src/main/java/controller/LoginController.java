package controller;

import common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.LoginService;
import web.LoginForm;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public Result login(LoginForm loginForm){
        Integer temp=loginService.loginJudge(loginForm);
        switch(temp){
            case 1:
                return new Result(true,1001+"","密码正确，登陆成功",null);
            case 2:
                return new Result(true,1002+"","密码错误，登陆失败",null);
            case 3:
                return new Result(true,1003+"","用户名错误",null);
            default:
                return new Result(false,1004+"","查询失败",null);

        }

    }
}
