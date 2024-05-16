package com.example.javabarapp.Repository;

import com.example.javabarapp.Model.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRepository extends JpaRepository<Cocktail,Long> {
}
