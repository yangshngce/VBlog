package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Users;
import service.registerService;

import java.util.Map;

@Controller
public class registerController {
    /*@Autowired
    private registerService registerService;
    @RequestMapping("/addUser")
    public Map<String,Object> adduser(Users users){
        return registerService.adduser(users);
    }*/
}
