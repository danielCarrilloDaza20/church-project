package co.edu.uptc.gerencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/footer")
public class FooterControler {

    @GetMapping("/aboutUs")
    public String aboutUs(){
        return "/footerInfo/aboutUs";
    }

    @GetMapping("/contact")
    public String contact(){
        return "/footerInfo/contact";
    }

    @GetMapping("/privacy")
    public String privacy(){
        return "/footerInfo/privacy";
    }

    @GetMapping("/terms")
    public String terms(){
        return "/footerInfo/terms";
    }
}
