package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.entity.Course;
import co.edu.uptc.gerencia.entity.Student;

import java.util.List;

public interface CourseService {

    List<Student> getCourses();

    Student getPorId(Long id);

    void createCourse(Student Student);

    void updateById(Long id, Student Student);

    void deleteStudent(Long id);

    public Course obtenerCoursePorId(Long id);

    public Course getCourseOfStudent(Long studentId);
}
