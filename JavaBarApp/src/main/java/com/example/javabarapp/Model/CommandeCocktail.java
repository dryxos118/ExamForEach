package com.example.javabarapp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "commande_cocktail")
public class CommandeCocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande_cocktail", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_commande")
    @Getter
    private Commande idCommande;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cocktail")
    @Getter
    private Cocktail Cocktail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_taille")
    @Getter
    private Taille idTaille;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "status_cocktail", nullable = false)
    private String statusCocktail;
}