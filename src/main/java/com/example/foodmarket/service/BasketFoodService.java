package com.example.foodmarket.service;

import com.example.foodmarket.DTO.BasketFoodDTO;
import com.example.foodmarket.exceptions.NotFoundException;
import com.example.foodmarket.model.Basket;
import com.example.foodmarket.model.BasketFood;
import com.example.foodmarket.model.Food;
import com.example.foodmarket.repository.BasketFoodRepository;
import com.example.foodmarket.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketFoodService {
    private final BasketFoodRepository basketFoodRepository;
    private final BasketRepository basketRepository;
    private final FoodService foodService;


    public Object create(BasketFoodDTO basketFoodDTO) {

        Basket basket = basketRepository.findById(basketFoodDTO.basketId()).orElseThrow(() -> new NotFoundException("Not found basket"));
        Food food = foodService.getFoodById(basketFoodDTO.foodId());

        BasketFood basketFood = new BasketFood();
        basketFood.setBasket(basket);
        basketFood.setFood(food);
        basketFood.setCount(basketFoodDTO.count());

        return basketFoodRepository.save(basketFood);

    }


    public Object get(Integer id) {
        return basketFoodRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found basketFood"));
    }
}
