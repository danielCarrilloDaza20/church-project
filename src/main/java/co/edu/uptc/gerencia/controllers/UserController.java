package co.edu.uptc.gerencia.controllers;

import co.edu.uptc.gerencia.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/user")
    public String user(Model model) {

        List<Course> cursos = Arrays.asList(
                new Course("Nivel 1", "Nivel 1 de proceso de formación"),
                new Course("Nivel 2", "Nivel 2 de proceso de formación"),
                new Course("Nivel 3", "Nivel 1 de proceso de formación")
        );

        model.addAttribute("courses", cursos);

        return "userView";
    }
}
