package com.example.jpapagination.controller;

import com.example.jpapagination.model.HttpResponse;
import com.example.jpapagination.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {
    private final UserService userService;


    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<HttpResponse> getUsers(@RequestParam Optional<String> name,
                                                 @RequestParam Optional<Integer> page,
                                                 @RequestParam Optional<Integer> size) throws InterruptedException {

        return ResponseEntity.ok().body(
                new HttpResponse(
                        LocalDateTime.now().toString(),
                        HttpStatus.OK.value(),
                        HttpStatus.OK,
                        "Users Retrieved",

                        Map.of("page",
                                userService.getUsers(name.orElse(""),
                                        page.orElse(0),
                                        size.orElse(10)))
                ));

    }
}

