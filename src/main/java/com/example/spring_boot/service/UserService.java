package com.example.spring_boot.service;



import com.example.spring_boot.models.User;

import java.util.List;

public interface UserService {

     List<User> getAllUsers();
     User getUserById(int id);
     void saveUser(User user);
     void updateUser(int id, User updateUser);
     void deleteUser(int id);


}
