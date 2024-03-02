package ru.maksmusic.mvc_authorization.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maksmusic.mvc_authorization.servisecs.LoggingSessionService;


@Controller
public class MainController {
    private final LoggingSessionService loggingSessionService;

    public MainController(LoggingSessionService loggingSessionService) {
        this.loggingSessionService = loggingSessionService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model){

        if (logout != null){
            loggingSessionService.setLogin(null);
        }

        String login = loggingSessionService.getLogin();
        if (login == null){
            return "redirect:/";
        }

        model.addAttribute("login",login);
        return "main.html";

    }
}
