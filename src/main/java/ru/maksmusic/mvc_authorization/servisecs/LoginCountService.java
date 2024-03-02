package ru.maksmusic.mvc_authorization.servisecs;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
@Service
@ApplicationScope
@Getter
public class LoginCountService {
    private int count = 0;

    public void increment(){
        count++;
    }
}
