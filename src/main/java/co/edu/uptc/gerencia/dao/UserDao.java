package co.edu.uptc.gerencia.dao;

import co.edu.uptc.gerencia.entity.User;

public interface UserDao {
    User findByUserName(String userName);
    User findByDocumentNumber(String documentNumber);
    void save(User user);
}
