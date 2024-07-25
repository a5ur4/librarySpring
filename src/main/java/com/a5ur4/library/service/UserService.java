package com.a5ur4.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a5ur4.library.entitys.UserEntity;
import com.a5ur4.library.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void createUser(String name, String password, String email) {
        UserEntity newUser = new UserEntity(name, password, email, "No book", null);
        this.repository.save(newUser);
    }

    public void deleteUser(Integer id, String name) {
        if (!this.repository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        this.repository.deleteById(id);
    }

    public void updateUser(Integer id, String name, String password, String email) {
        UserEntity user = this.repository.findUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        this.repository.save(user);
    }

    public Integer findUserById(Integer id) {
        return this.repository.findUserById(id).orElseThrow(() -> new RuntimeException("User not found")).getId();
    }

    public List<UserEntity> listAllUsers() {
        return this.repository.findAll();
    }
}
