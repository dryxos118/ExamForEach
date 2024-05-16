package com.example.javabarapp.Repository;

import com.example.javabarapp.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
