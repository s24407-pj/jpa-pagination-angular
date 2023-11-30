package com.example.jpapagination.service;

import com.example.jpapagination.model.User;
import org.springframework.data.domain.Page;


public interface UserService {
    Page<User> getUsers(String name, int page, int size);
}
