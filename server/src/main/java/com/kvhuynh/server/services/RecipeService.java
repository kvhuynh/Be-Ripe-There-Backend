package com.kvhuynh.server.services;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import com.kvhuynh.server.repositories.RecipeRepository;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;


    public void createRecipe(@RequestBody Map<String, Object> recipeRequest, BindingResult result) {
        // System.out.println(recipeRequest.getRecipeName());

        // recipeRepository.save();
        if (result.hasErrors()) {
            System.out.println("we have errors");
        }

    }

    public Ingredient processIngredient(@RequestBody String) {
        return null;
    }
}
