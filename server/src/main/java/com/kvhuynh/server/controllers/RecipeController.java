package com.kvhuynh.server.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvhuynh.server.models.recipes.Recipe;
import com.kvhuynh.server.security.models.AuthenticationResponse;
import com.kvhuynh.server.services.RecipeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/create")
    // private ResponseEntity<AuthenticationResponse> createRecipe(@RequestBody Map<String, Object> recipeRequest, BindingResult result) {
    private ResponseEntity<AuthenticationResponse> createRecipe(@RequestBody Recipe recipe, BindingResult result) {



        System.out.println("Recipe has been successfully added to the database");
        System.out.println(recipe);
        // System.out.println(recipeRequest.get("carbohydrateAmount"));
        // recipeService.createRecipe(recipeRequest, result);
        return null;
    }

    public List<Recipe> getAllRecipes() {
        return null;
    }

    public List<Recipe> getFavoriteRecipes() {
        return null;
    }
}
