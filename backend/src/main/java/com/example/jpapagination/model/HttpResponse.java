package com.example.jpapagination.model;

import org.springframework.http.HttpStatus;

import java.util.Map;

public record HttpResponse(String timeStamp,
                           int statusCode,
                           HttpStatus status,
                           String message,
                           Map<?, ?> data) {
}
