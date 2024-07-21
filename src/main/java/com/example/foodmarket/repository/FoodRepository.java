package com.example.foodmarket.repository;

import com.example.foodmarket.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}
