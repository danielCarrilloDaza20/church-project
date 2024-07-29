package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.entity.Course;
import co.edu.uptc.gerencia.entity.Student;
import co.edu.uptc.gerencia.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> findByCourse(Long courseId) {
        return studentRepository.findByCourse(courseId);
    }
}
