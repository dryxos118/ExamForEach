package com.example.javabarapp.Repository;

import com.example.javabarapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMail(String email);
    Boolean existsByMail(String email);
}
