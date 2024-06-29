package co.edu.uptc.gerencia.controllers;

import co.edu.uptc.gerencia.model.User;
import co.edu.uptc.gerencia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String verifyLogin(@ModelAttribute User login){
        User usuaio = userService.getByUserName(login);
        return "redirect:/user";
    }
}
