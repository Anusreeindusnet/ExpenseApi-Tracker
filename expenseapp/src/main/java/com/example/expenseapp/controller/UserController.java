package com.example.expenseapp.controller;

import com.example.expenseapp.entity.User;
import com.example.expenseapp.entity.UserDto;
import com.example.expenseapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> save( @Valid  @RequestBody UserDto user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);

    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> readUser(@PathVariable Long id){
        return new ResponseEntity<User>(userService.readUser(id),HttpStatus.OK);

    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User>updateUser(@RequestBody UserDto user,@PathVariable Long id){
        return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);

    }
}
