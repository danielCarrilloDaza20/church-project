package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.entity.Course;
import co.edu.uptc.gerencia.entity.Student;
import co.edu.uptc.gerencia.repos.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Course obtenerCoursePorId(Long id) {
        String sql = "SELECT * FROM course WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Course.class));
    }

    public Course getCourseOfStudent(Long studentId) {
        String sql = "SELECT MAX(course_id) from enrollment where student_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{studentId}, new BeanPropertyRowMapper<>(Course.class));
    }

    @Override
    public List<Student> getCourses() {
        return List.of();
    }

    @Override
    public Student getPorId(Long id) {
        return null;
    }

    @Override
    public void createCourse(Student Student) {

    }

    @Override
    public void updateById(Long id, Student Student) {

    }

    @Override
    public void deleteStudent(Long id) {

    }
}
