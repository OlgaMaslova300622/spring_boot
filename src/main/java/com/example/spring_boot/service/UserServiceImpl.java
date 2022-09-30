package com.example.spring_boot.service;


import com.example.spring_boot.dao.UserDAO;
import com.example.spring_boot.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserDAO userDAO;


    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }
    @Transactional
    @Override
    public void updateUser(int id, User updateUser) {
        userDAO.updateUser(id, updateUser);

    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);

    }
}
