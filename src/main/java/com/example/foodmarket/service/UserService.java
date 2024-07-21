package com.example.foodmarket.service;

import com.example.foodmarket.DTO.UserDTO;
import com.example.foodmarket.model.User;
import com.example.foodmarket.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public String signUp(UserDTO userDTO) {

        if (userRepository.existsByPhoneNumber(userDTO.getPhoneNumber())) {
            log.warn("Phone is already registrated");
            throw new  RuntimeException("Phone is already registrated");
        }
        User user = new User();
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPassword(userDTO.getPassword());

        userRepository.save(user);
        log.debug("New User signed up: {}",user);
        return "Successfully";
    }

    public User login(UserDTO userDTO) {

        User user = userRepository.findByPhoneNumberAndPassword(userDTO.getPhoneNumber(), userDTO.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("Login or Password is not valid."));


        log.debug("One user signed in: {}", user);
        return user;
    }
}
