package co.edu.uptc.gerencia.repos;

import co.edu.uptc.gerencia.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Enrollment e WHERE e.student.id = :studentId")
    void deleteEnrollmentByStudentId(@Param("studentId") Long studentId);


}
