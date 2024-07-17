package co.edu.uptc.gerencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeachersController {

    @GetMapping("")
    public String teachers() {

        return "teachers";
    }

    @GetMapping("asistencias")
    public String asistencias() {

        return "asistencias";
    }

    @GetMapping("contenidos")
    public String contenidos() {

        return "contenidos";
    }

    @GetMapping("talleres")
    public String talleres() {

        return "talleres";
    }
}
