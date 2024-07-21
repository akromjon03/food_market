package com.example.foodmarket.repository;

import com.example.foodmarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByPhoneNumberAndPassword(String phoneNumber, String password);
    boolean existsByPhoneNumber(String phoneNumber);
}
