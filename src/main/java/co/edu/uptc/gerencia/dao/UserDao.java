package co.edu.uptc.gerencia.dao;

import co.edu.uptc.gerencia.entity.User;

public interface UserDao {
    User findByUserName(String userName);

    void save(User user);
}
