package com.example.service;


import com.example.dao.Impl.UserDaoImpl;
import com.example.dao.UserDao;
import com.example.entities.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDaoImpl();

    public void createUser(User user) {
        userDao.save(user);
    }

    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(Long id) {
        userDao.delete(id);
    }
}