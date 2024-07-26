package com.a5ur4.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a5ur4.library.dtos.UserDTO;
import com.a5ur4.library.entitys.UserEntity;
import com.a5ur4.library.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO user) {
        this.userService.createUser(user.name(), user.password(), user.email());
        return ResponseEntity.ok("User created");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody UserDTO user) {
        this.userService.deleteUser(user.id(), user.name());
        return ResponseEntity.ok("User " + user.name() + " deleted");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO user) {
        this.userService.updateUser(user.id(), user.name(), user.password(), user.email());
        return ResponseEntity.ok("User " + user.name() + " updated");
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<UserEntity>> listAllUsers() {
        return ResponseEntity.ok(this.userService.listAllUsers());
    }
}
