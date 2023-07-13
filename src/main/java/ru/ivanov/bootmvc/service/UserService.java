package ru.ivanov.bootmvc.service;

import ru.ivanov.bootmvc.model.User;

import java.util.List;

public interface UserService {
    //    void add(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    void updateUser(User updateUser);

    void removeUserById(long id);
    void save(User user);
}