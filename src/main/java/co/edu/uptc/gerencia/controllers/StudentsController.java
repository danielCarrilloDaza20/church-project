package co.edu.uptc.gerencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students")
public class StudentsController {

    @GetMapping("/personal-data")
    public String showTeachers(){
        return "datosPersonales";
    }

    @GetMapping("/course-materials")
    public String showStudents(){
        return "materiales";
    }

    @GetMapping("/process-info")
    public String showProcesInfo(){
        return "informacionProceso";
    }
}
