package co.edu.uptc.gerencia.service;

import co.edu.uptc.gerencia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplementation implements UserService{

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User getByUserName(User username) {

        return null;
    }

    @Override
    public User createUser(User User) {
        return null;
    }

    @Override
    public User updateById(int id, User User) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
