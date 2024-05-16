package com.example.javabarapp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cocktail_ingredient")
public class CocktailIngredient {
    @EmbeddedId
    private CocktailIngredientId id;

    @Column(name = "quantity")
    private String quantity;

}