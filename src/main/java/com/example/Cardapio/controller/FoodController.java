package com.example.Cardapio.controller;

import com.example.Cardapio.food.Food;
import com.example.Cardapio.food.FoodRepository;
import com.example.Cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;
    @PostMapping
    public void saveFood(@RequestBody FoodResponseDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        return repository.findAll().stream().map(FoodResponseDTO::new).toList();
    }
}
