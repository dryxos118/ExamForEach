package com.example.javabarapp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cocktail")
public class Cocktail {
    @Id
    @Column(name = "id_cocktail", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_S")
    private Double priceS;

    @Column(name = "price_M")
    private Double priceM;

    @Column(name = "price_L")
    private Double priceL;

    @Column(name = "img")
    private String img;

    @ManyToMany
    @JoinTable(name = "cocktail_category",
            joinColumns = @JoinColumn(name = "id_cocktail"),
            inverseJoinColumns = @JoinColumn(name = "id_category"))
    private Set<Category> categories;

    @ManyToMany
    @JoinTable(name = "cocktail_ingredient",
            joinColumns = @JoinColumn(name = "id_cocktail"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
    private Set<Ingredient> ingredients;
}