package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import po.UserPo;
import service.LoginService;
import web.LoginForm;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer loginJudge(LoginForm loginForm) {
        System.out.println(loginForm);
        UserPo userPo=userMapper.judgeUser(loginForm.getUsername());
        System.out.println(userPo);
        if (userPo==null){
            return 3;
        }else {
            if (userPo.getPASSWORD().equals(loginForm.getPassword())){
                return 1;
            }
            return 2;
        }
    }
}
