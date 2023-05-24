package com.kvhuynh.server.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvhuynh.server.models.recipes.Recipe;
import com.kvhuynh.server.security.models.AuthenticationResponse;
import com.kvhuynh.server.services.RecipeService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/create")
    private ResponseEntity<AuthenticationResponse> createRecipe(@RequestBody Recipe recipe, BindingResult result, HttpSession session) {

        System.out.println("Recipe has been successfully added to the database");
        System.out.println(session.getAttribute("uuid"));

        Recipe newRecipe = recipeService.createRecipe(recipe, result);
        recipeService.processIngredient(newRecipe);
        System.out.println(newRecipe);
        return null;
    }

    @GetMapping("/")
    public List<Recipe> getAllRecipes(HttpSession session) {
        System.out.println(session.getAttribute("uuid"));
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Optional<Recipe> getOneRecipe(@PathVariable("id") Long id) {
        return recipeService.getOneRecipeById((long)1);
    }

    public List<Recipe> getFavoriteRecipes() {
        return null;
    }
}
