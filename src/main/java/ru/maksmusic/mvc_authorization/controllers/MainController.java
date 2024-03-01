package ru.maksmusic.mvc_authorization.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maksmusic.mvc_authorization.servisecs.LoggingSessionServices;


@Controller
public class MainController {
    private final LoggingSessionServices loggingSessionServices;

    public MainController(LoggingSessionServices loggingSessionServices) {
        this.loggingSessionServices = loggingSessionServices;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model){

        if (logout != null){
            loggingSessionServices.setLogin(null);
        }

        String login = loggingSessionServices.getLogin();
        if (login == null){
            return "redirect:/";
        }

        model.addAttribute("login",login);
        return "main.html";

    }
}
