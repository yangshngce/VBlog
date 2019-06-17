package service;

import web.LoginForm;
import web.RegisterForm;

public interface UsrService {
    Integer loginJudge(LoginForm loginForm);
    Integer register(RegisterForm registerForm);
}
