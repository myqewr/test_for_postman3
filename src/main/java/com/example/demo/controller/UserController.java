package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public record Me(String name, Integer age){};
    
    @GetMapping
    public ResponseEntity<Me> me(){
        return ResponseEntity.ok(new Me("minyoung",10));
    }

}
