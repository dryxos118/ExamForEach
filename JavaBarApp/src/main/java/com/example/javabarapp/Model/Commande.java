package com.example.javabarapp.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande", nullable = false)
    private Long id;

    @Column(name = "created")
    private Date created;

    @Column(name = "status_commande")
    private String statusCommande;

}