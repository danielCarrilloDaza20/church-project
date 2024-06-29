package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.model.User;

import java.util.List;

public interface UserService {
    
    List<User> getUsers();

    User getById(int id);

    User getByUserName(User username);

    User createUser(User User);

    User updateById(int id, User User);

    void deleteUser(int id);
}
