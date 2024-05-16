package com.example.javabarapp.Repository;

import com.example.javabarapp.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
