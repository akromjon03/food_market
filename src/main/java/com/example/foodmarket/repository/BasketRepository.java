package com.example.foodmarket.repository;

import com.example.foodmarket.model.Basket;
import com.example.foodmarket.model.enums.BasketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Optional<Basket> findByUserIdAndBasketStatus(Integer id, BasketStatus basketStatus);
}
