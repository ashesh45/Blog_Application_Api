package com.blog.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.example.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
