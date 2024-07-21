package com.example.foodmarket.repository;

import com.example.foodmarket.model.BasketFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketFoodRepository extends JpaRepository<BasketFood, Integer> {
}
