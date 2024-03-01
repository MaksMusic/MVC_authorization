package ru.maksmusic.mvc_authorization.servisecs;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LoginProcessor {
    private LoggingSessionServices loggingSessionServices;

    public LoginProcessor(LoggingSessionServices loggingSessionServices) {
        this.loggingSessionServices = loggingSessionServices;
    }

    private String login;
    private String password;



    public boolean isConnect(){
        String login =  getLogin();
        String password =  getPassword();

        boolean b =  login.equals("Admin") && password.equals("12345");
        if (b){
            loggingSessionServices.setLogin(login);
        }
        return b;
    }
}
