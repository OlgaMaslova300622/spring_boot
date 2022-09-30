package com.example.spring_boot.dao;



import com.example.spring_boot.models.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();
    User getUserById(int id);
    void saveUser(User user);
    void updateUser(int id, User updateUser);
    void deleteUser(int id);

}
