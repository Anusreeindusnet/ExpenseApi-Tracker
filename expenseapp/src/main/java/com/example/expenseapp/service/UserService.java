package com.example.expenseapp.service;

import com.example.expenseapp.entity.User;
import com.example.expenseapp.entity.UserDto;

public interface UserService {

    User createUser(UserDto user);

    User readUser(Long id);

    User updateUser(UserDto user,Long id);
}
