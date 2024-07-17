package co.edu.uptc.gerencia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/landing")
    public String showLandingPage() {
        return "landing-page";
    }

    @GetMapping({"/home", "", "/"})
    public String home(){
        return "home";
    }

    // request mapping para /teachers
/*    @GetMapping({"/teachers"})
    public String showTeachers(){
        return "teachers";
    }
*/
    // request mapping para /students
    @GetMapping({"/students"})
    public String showStudents(){
        return "students";
    }
}
