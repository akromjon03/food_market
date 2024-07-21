package com.example.foodmarket.service;

import com.example.foodmarket.exceptions.NotFoundException;
import com.example.foodmarket.model.Basket;
import com.example.foodmarket.model.enums.BasketStatus;
import com.example.foodmarket.repository.BasketRepository;
import com.example.foodmarket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final UserRepository userRepository;


    public Object create(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("User not found");
        }

        Optional<Basket> oldBasket = basketRepository.findByUserIdAndBasketStatus(id, BasketStatus.BASKET);
        if (oldBasket.isPresent()) {
            return oldBasket.get();
        }

        Basket basket = new Basket();
        basket.setBasketStatus(BasketStatus.BASKET);
        basket.setUser(userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found")));
        basketRepository.save(basket);
        return basket;
    }

    public Object get(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("User not found");
        }

        Optional<Basket> oldBasket = basketRepository.findByUserIdAndBasketStatus(userId, BasketStatus.BASKET);
        if (oldBasket.isPresent()) {
            return oldBasket.get();
        }
        return "Current basket not found";
    }

    public Object orderFood(Integer basketId){

        return null;
    }
}
