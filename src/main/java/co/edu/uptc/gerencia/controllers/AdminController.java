package co.edu.uptc.gerencia.controllers;

import co.edu.uptc.gerencia.entity.User;
import co.edu.uptc.gerencia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/students")
    public List<User> showStudents() {
        List<User> students = new ArrayList<>();
        return students;
    }
}
