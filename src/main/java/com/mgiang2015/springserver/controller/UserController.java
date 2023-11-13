package com.mgiang2015.springserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mgiang2015.springserver.model.user.UserDao;
import com.mgiang2015.springserver.model.user.User;

import java.util.List;

@RestController
public class UserController {
    
    @Autowired
    private UserDao userDao;

    @GetMapping("/users/get-all")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @GetMapping(value = "/users/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        try {
            return userDao.getUserByUsername(username);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username " + username + " does not exist");
        }
    }

    @PostMapping("/users/save")
    public User save(@RequestBody User user) {
        return userDao.save(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id) {
        try {
            return userDao.updateUser(id, user);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User id " + id.toString() + " does not exist");
        }
    }
}
