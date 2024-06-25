package co.edu.uptc.gerencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping({"/home", "", "/"})
    public String registry(){
        return "home";
    }
}
