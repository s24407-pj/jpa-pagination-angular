package com.example.jpapagination.service.implementation;

import com.example.jpapagination.model.User;
import com.example.jpapagination.repository.UserRepository;
import com.example.jpapagination.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> getUsers(String name, int page, int size) {
        return userRepository.findByNameContaining(name, PageRequest.of(page, size));
    }
}
