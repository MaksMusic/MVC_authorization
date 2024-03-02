package ru.maksmusic.mvc_authorization.controllers;


import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maksmusic.mvc_authorization.servisecs.LoginProcessor;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet(Model model){
        model.addAttribute("count",loginProcessor.getLoginCountService().getCount());
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String login,
            @RequestParam String password,
            Model model){

        loginProcessor.setLogin(login);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.isConnect();

        if (loggedIn){
            return "redirect:/main";
        }

        model.addAttribute("message","логин или пароль не действителен");
        model.addAttribute("count",loginProcessor.getLoginCountService().getCount());
        return "login.html";

    }


}
