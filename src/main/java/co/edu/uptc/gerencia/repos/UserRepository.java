package co.edu.uptc.gerencia.repos;

import co.edu.uptc.gerencia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
