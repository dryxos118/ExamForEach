package com.example.javabarapp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @Column(name = "id_ingredient", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

}