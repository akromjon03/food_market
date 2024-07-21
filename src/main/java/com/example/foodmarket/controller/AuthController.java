package com.example.foodmarket.controller;

import com.example.foodmarket.DTO.UserDTO;
import com.example.foodmarket.model.User;
import com.example.foodmarket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/evos/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.signUp(userDTO));

    }
    @PostMapping("/signIn")
    public ResponseEntity<User> login(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.login(userDTO));
    }
}
