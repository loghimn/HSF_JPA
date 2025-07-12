package com.springboot.jpa.springdatajap.service;

import com.springboot.jpa.springdatajap.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
}
