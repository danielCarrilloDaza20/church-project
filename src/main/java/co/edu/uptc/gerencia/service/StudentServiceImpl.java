package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.entity.Student;
import co.edu.uptc.gerencia.repos.CourseRepository;
import co.edu.uptc.gerencia.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public Student getPorId(Long id) {
        return repository.getById(id);
    }

    @Override
    public void createStudent(Student student) {
        repository.save(student);
    }

    @Override
    public void updateById(Long id, Student student) {

        Student studentDB = getPorId(id);
        if (studentDB != null) {
            studentDB.setUser(student.getUser());
            studentDB.setId(student.getId());
        }
        repository.save(studentDB);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
