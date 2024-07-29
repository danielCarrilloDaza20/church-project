package co.edu.uptc.gerencia.controllers;

import co.edu.uptc.gerencia.entity.Course;
import co.edu.uptc.gerencia.entity.User;
import co.edu.uptc.gerencia.repos.CourseRepository;
import co.edu.uptc.gerencia.service.CourseService;
import co.edu.uptc.gerencia.service.CourseServiceImpl;
import co.edu.uptc.gerencia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("students")
public class StudentsController {

    @Autowired
    UserService userService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/course-materials")
    public String showStudentsMaterials(){
        return "materiales";
    }

    @GetMapping("/process-info")
    public String showProcesInfo(){
        return "informacionProceso";
    }

    @GetMapping("/personal_data/{id}")
    public String obtenerEstudiante(@PathVariable String id, Model model) {
        User estudiante = userService.findByUserName(id);
        model.addAttribute("estudiante", estudiante);
        return "datosPersonales";
    }
    @GetMapping("/{id}")
    public String showCourses(@PathVariable Long id, Model model){

        Course idCoursing = courseService.getCourseOfStudent(id);
        System.out.println(idCoursing);
        model.addAttribute("idCusrsando", idCoursing.getId());
        return "students";
    }
}
