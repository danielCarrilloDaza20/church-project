package co.edu.uptc.gerencia.controllers;

import co.edu.uptc.gerencia.entity.Course;
import co.edu.uptc.gerencia.entity.Student;
import co.edu.uptc.gerencia.repos.CourseRepository;
import co.edu.uptc.gerencia.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/landing")
    public String showLandingPage() {
        return "landing-page";
    }

    @GetMapping({"/home", "", "/"})
    public String home(Model model){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        model.addAttribute("courses", courses);
        return "home";
    }

    // request mapping para /teachers
    @GetMapping({"/teachers"})
    public String showTeachers(){
        return "teachers";
    }

    @GetMapping("/students")
    public String showAllStudents(Model model){
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "allStudents";
    }

    // request mapping para /students
    @GetMapping({"/students/{courseId}"})
    public String showStudentsByCourseId(@PathVariable("courseId") Long courseId, Model model){
        Course course = courseRepository.findById(courseId).get();
        List<Student> students = studentRepository.findByCourse(courseId);
        model.addAttribute("course", course);
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/lessons/{courseId}")
    public String showLessonsByCourseId(@PathVariable("courseId") Long courseId, Model model){
        Course course = courseRepository.findById(courseId).get();
        List<Course> courses = courseRepository.findAll();
        int cantLessons = 0;
        if (course.getId() == 1){
            cantLessons = 12;
        }else if (course.getId() == 2 || course.getId() == 3){
            cantLessons = 8;
        }
        model.addAttribute("courses", courses);
        model.addAttribute("course", course);
        model.addAttribute(cantLessons);
        return "lessons";
    }
}
