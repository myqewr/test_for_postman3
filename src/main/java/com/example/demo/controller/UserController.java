package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public record Token(String accessToken, String refreshToken){}
    public record Me(String name, Integer age){};

    public record LoginReq(String loginId, String password){};
    public record AuthInfo(String accessToken){};

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody LoginReq loginReq){
        if(loginReq.loginId!=null) {
            return ResponseEntity.ok(new Token("accessToken", "refreshToken"));
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/me/info")
    public ResponseEntity<Me> me(@RequestBody AuthInfo authInfo){

        if(authInfo.accessToken!=null) {
            return ResponseEntity.ok(new Me("minyoung",10));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}
