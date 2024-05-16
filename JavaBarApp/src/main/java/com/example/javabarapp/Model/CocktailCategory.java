package com.example.javabarapp.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cocktail_category")
public class CocktailCategory {
    @EmbeddedId
    private CocktailCategoryId id;

}