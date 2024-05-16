package com.example.javabarapp.Repository;

import com.example.javabarapp.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
