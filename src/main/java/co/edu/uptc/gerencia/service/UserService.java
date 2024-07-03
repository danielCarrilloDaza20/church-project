package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.entity.User;
import co.edu.uptc.gerencia.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);

    void save(WebUser webUser);
}
