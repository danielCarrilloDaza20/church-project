package co.edu.uptc.gerencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("teachers")
public class TeachersController {

    @GetMapping("/assistances")
    public String showTeachers(){
        return "asistencias";
    }

    @GetMapping("/content")
    public String showContent(){
        return "contenidos";
    }

    @GetMapping("/talleres")
    public String showTalleres(){
        return "talleres";
    }
}
