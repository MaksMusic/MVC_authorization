package ru.maksmusic.mvc_authorization.servisecs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoggingSessionService {

    private String login;

}
