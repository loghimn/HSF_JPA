package com.springboot.jpa.springdatajap.repository;

import com.springboot.jpa.springdatajap.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
