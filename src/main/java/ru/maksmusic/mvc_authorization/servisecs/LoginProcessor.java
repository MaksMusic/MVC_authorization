package ru.maksmusic.mvc_authorization.servisecs;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LoginProcessor {
    private LoggingSessionService loggingSessionService;
    private LoginCountService loginCountService;

    public LoginProcessor(LoggingSessionService loggingSessionService, LoginCountService loginCountService) {
        this.loggingSessionService = loggingSessionService;
        this.loginCountService = loginCountService;
    }

    private String login;
    private String password;



    public boolean isConnect(){
        loginCountService.increment();
        String login =  getLogin();
        String password =  getPassword();

        boolean b =  login.equals("Admin") && password.equals("12345");
        if (b){
            loggingSessionService.setLogin(login);
        }
        return b;
    }
}
