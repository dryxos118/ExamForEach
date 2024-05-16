package com.example.javabarapp.Controller;

import com.example.javabarapp.Model.Cocktail;
import com.example.javabarapp.Model.Commande;
import com.example.javabarapp.Model.CommandeCocktail;
import com.example.javabarapp.Model.Taille;
import com.example.javabarapp.Repository.CocktailRepository;
import com.example.javabarapp.Repository.CommandeCocktailRepository;
import com.example.javabarapp.Repository.CommandeRepository;
import com.example.javabarapp.Repository.TailleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CocktailRepository cocktailRepository;

    @Autowired
    private TailleRepository tailleRepository;

    @Autowired
    private CommandeCocktailRepository commandeCocktailRepository;

    @GetMapping("/commands")
    public List<CommandeCocktail> GetCommande(){
        return commandeCocktailRepository.findAll();
    }

    @PostMapping("/commands/add")
    public Boolean AddCommande(@RequestParam Long id_cocktail){
        Cocktail cocktail = cocktailRepository.findById(id_cocktail).orElse(null);
        if(cocktail == null){
            return false;
        }else{
            Commande commande = new Commande();
            CommandeCocktail commandeCocktail = new CommandeCocktail();
            commande.setStatusCommande("Commander");
            commande.setCreated(new Date());

            commandeCocktail.setIdCommande(commande);
            commandeCocktail.setCocktail(cocktail);
            commandeCocktail.setIdTaille(tailleRepository.findById(2L).orElse(null));
            commandeCocktail.setQuantity(2L);
            commandeCocktail.setStatusCocktail("Commander");

            commandeRepository.save(commande);
            commandeCocktailRepository.save(commandeCocktail);
            return true;
        }
    }

    @PostMapping("/commands/status")
    public Boolean StatusCommande(@RequestParam Long id_commande){
        CommandeCocktail commandeCocktail = commandeCocktailRepository.findById(id_commande).orElse(null);
        if(commandeCocktail != null){

            switch (commandeCocktail.getStatusCocktail()){
                case "Commander":
                    commandeCocktail.setStatusCocktail("En cours de preparation");
                    commandeCocktailRepository.save(commandeCocktail);
                    break;
                case "En cours de preparation":
                    commandeCocktail.setStatusCocktail("Terminer");
                    commandeCocktailRepository.save(commandeCocktail);
                    break;
                case "Terminer":
                    commandeCocktailRepository.delete(commandeCocktail);
                    break;
                default:
                    return false;
            }
            return true;
        }else{
            return false;
        }
    }
}
