package com.kvhuynh.server.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kvhuynh.server.models.recipes.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    
}
