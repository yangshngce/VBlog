package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.UserPo;
import service.UsrService;
import web.LoginForm;
import web.RegisterForm;

import java.time.LocalDateTime;

@Service
public class UsrServiceImpl implements UsrService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPo userPo;

    @Override
    public Integer loginJudge(LoginForm loginForm) {
        System.out.println("正在运行loginJudge方法");
        System.out.println(loginForm);
        userPo=userMapper.judgeUser(loginForm.getUsername());
        System.out.println("查询结果userPo"+userPo);
        System.out.println(userPo);
        if (userPo==null){
            return 3;
        }else {
            if (userPo.getUSR_PWD().equals(loginForm.getPassword())){
                return 1;
            }
            return 2;
        }
    }

    @Override
    public Integer register(RegisterForm registerForm) {
        System.out.println("用户注册：");
        System.out.println(registerForm);

        Integer temp=loginJudge(new LoginForm(registerForm.getUser_name()));
        System.out.println("temp:"+temp);
        if(temp!=3)
            return 2;
        System.out.println("************");
        System.out.println("userPo:"+userPo);
        UserPo userPoTemp=new UserPo();
        userPoTemp.setUSR_NAME(registerForm.getUser_name());
        userPoTemp.setUSR_PWD(registerForm.getPassword());
        userPoTemp.setSEX(registerForm.getSex());
        userPoTemp.setAGE(registerForm.getAge());
        userPoTemp.setCREATE_TIME(LocalDateTime.now().toString());
        userPoTemp.setEMAIL(registerForm.getEmail());
        System.out.println("---------------");
        System.out.println("userPoTemp:"+userPoTemp);

        Integer count=userMapper.addUser(userPoTemp);

        return count>0?1:0;

    }

}
