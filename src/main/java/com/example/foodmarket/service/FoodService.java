package com.example.foodmarket.service;

import com.example.foodmarket.DTO.FoodDTO;
import com.example.foodmarket.exceptions.NotFoundException;
import com.example.foodmarket.model.Category;
import com.example.foodmarket.model.Food;
import com.example.foodmarket.repository.CategoryRepository;
import com.example.foodmarket.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    public String create(FoodDTO foodDTO) {
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setPrice(foodDTO.getPrice());
        Category category = categoryRepository.findById(foodDTO.getCategoryId()).orElseThrow(() -> new NotFoundException("Not found category id"));
        food.setCategory(category);
        food.setDescription(foodDTO.getDescription());
        food.setPhotoURL(foodDTO.getPhotoURL());
        foodRepository.save(food);
        return "Added food";
    }

    public Food getFoodById(Integer id) {

        return foodRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found food"));
    }

    private boolean exists(Integer id) {
        return foodRepository.existsById(id);
    }

    public Object getAll() {
        List<Food> foods = foodRepository.findAll();
        if (foods.isEmpty()) {
            return "Not found food";
        }
        return foods;
    }

    public Object updateFood(FoodDTO foodDTO, Integer id) {
        if (!exists(id)) {
            throw new NotFoundException("Not found food");
        }

        Food food = new Food();
        food.setId(id);
        food.setName(foodDTO.getName());
        food.setPrice(foodDTO.getPrice());
        Category category = categoryRepository.findById(foodDTO.getCategoryId()).orElseThrow(() -> new NotFoundException("Not found category id"));
        food.setCategory(category);
        food.setDescription(foodDTO.getDescription());
        food.setPhotoURL(foodDTO.getPhotoURL());
        foodRepository.save(food);

        return "Updated food";
    }

    public Object delete(Integer id) {
        if (!exists(id)) {
            throw new NotFoundException("Not found food");
        }
        foodRepository.deleteById(id);

        return "Deleted food";
    }
}
