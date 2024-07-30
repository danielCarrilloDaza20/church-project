package co.edu.uptc.gerencia.controllers;

import co.edu.uptc.gerencia.entity.Course;
import co.edu.uptc.gerencia.entity.Enrollment;
import co.edu.uptc.gerencia.entity.Student;
import co.edu.uptc.gerencia.entity.User;
import co.edu.uptc.gerencia.repos.CourseRepository;
import co.edu.uptc.gerencia.repos.EnrollmentRepository;
import co.edu.uptc.gerencia.repos.StudentRepository;
import co.edu.uptc.gerencia.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/proceso")
public class ProcesoController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/enrollmentForm")
    public String showCoursesToEnroll(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "proceso/enrollToProcessForm.html";
    }

    @GetMapping("/myClasses")
    public String showClassesToStudent(Model model, Principal principal) {
        String currentUserName = principal.getName();
        User user = userRepository.findByUsername(currentUserName);
        return "proceso/classesToStudent";
    }

    @PostMapping("/enrollToProcess")
    public String enrollToProcess(@RequestParam("courseId") Long courseId, Principal principal, RedirectAttributes redirectAttributes) {
        String currentUserName = principal.getName();
        User user = userRepository.findByUsername(currentUserName);


        Student student = new Student();
        student.setUser(user);
        studentRepository.save(student);

        Course course = courseRepository.findById(courseId).get();

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);

        redirectAttributes.addFlashAttribute("message", "Inscrito correctamente");
        return "redirect:/proceso/enrollmentForm";
    }


}
