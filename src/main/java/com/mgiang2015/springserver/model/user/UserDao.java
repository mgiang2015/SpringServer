package com.mgiang2015.springserver.model.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    @Autowired
    private UserRepository repository;

    // Create
    public User save(User user) {
        return repository.save(user);
    }

    // Read
    public List<User> getAllUsers() {
        return Streamable.of(repository.findAll()).toList();
    }

    public User getUserByUsername(String username) throws Exception {
        List<User> users = Streamable.of(repository.findAll()).filter((user) -> {
            return user.getUsername().equals(username);
        }).toList();

        if (users.isEmpty()) {
            throw new Exception("User with username " + username + " does not exist!");
        }

        return users.get(0);
    }

    // Update
    public User updateUser(Integer id, User newUser) throws Exception {
        return repository.findById(id).map(
            user -> {
                user.setUsername(newUser.getUsername());
                user.setPassword(newUser.getPassword());
                return repository.save(user);
            }).orElseThrow(() -> new Exception("User with id " + id.toString() + " does not exist"));
    }

    // Delete
    public void delete(User user) {
        repository.delete(user);
        // no return value here
    }
}
