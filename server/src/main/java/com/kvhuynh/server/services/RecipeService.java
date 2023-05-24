package com.kvhuynh.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import com.kvhuynh.server.models.recipes.Ingredient;
import com.kvhuynh.server.models.recipes.Recipe;
import com.kvhuynh.server.repositories.recipes.IngredientRepository;
import com.kvhuynh.server.repositories.recipes.RecipeRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    private final IngredientRepository ingredientRepository;

    public Recipe createRecipe(@RequestBody Recipe recipe, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("we have errors");
        }

        return recipeRepository.save(recipe);

    }

    public void processIngredient(Recipe recipe, HttpSession session) {
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setIngredientName(recipe.getIngredients().get(i).getIngredientName());
            ingredient.setIngredientQuanitity(recipe.getIngredients().get(i).getIngredientQuanitity());
            ingredient.setRecipe(recipe);
            ingredientRepository.save(ingredient);

        }
    }

	public List<Recipe> getAllRecipes(HttpSession session) {
        // System.out.println("here");
		return recipeRepository.findAll();
        // System.out.println(recipeRepository.findAll());
        // return null;
	}

    public Optional<Recipe> getOneRecipeById(Long id, HttpSession session) {
        return recipeRepository.findById(id);
    }

}
