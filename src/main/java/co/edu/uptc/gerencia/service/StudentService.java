package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getPorId(Long id);

    void createStudent(Student Student);

    void updateById(Long id, Student Student);

    void deleteStudent(Long id);
    
}
