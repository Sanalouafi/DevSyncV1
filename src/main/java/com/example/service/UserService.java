package com.example.service;

import com.example.dao.Impl.UserDaoImpl;
import com.example.dao.UserDao;
import com.example.entities.User;
import org.mindrot.jbcrypt.BCrypt;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDaoImpl();

    public void createUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
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

    public User authenticate(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null) {
            System.out.println("User found: " + user.getUsername());
            if (BCrypt.checkpw(password, user.getPassword())) {
                return user;
            } else {
                System.out.println("Password does not match.");
            }
        } else {
            System.out.println("User not found.");
        }
        return null;
    }
}