package com.example.javabarapp.Repository;

import com.example.javabarapp.Model.Taille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TailleRepository extends JpaRepository<Taille, Long> {
}
