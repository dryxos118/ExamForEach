package com.example.javabarapp.Controller;

import com.example.javabarapp.Model.Cocktail;
import com.example.javabarapp.Repository.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CocktailController {
    @Autowired
    private CocktailRepository cRepository;

    @GetMapping("/cocktails")
    public List<Cocktail> GetCocktail() {
        return cRepository.findAll();
    }

    @PostMapping("/cocktail")
    public Cocktail GetCocktailById(@RequestParam Long id) {
        return cRepository.findById(id).orElse(null);
    }
}
