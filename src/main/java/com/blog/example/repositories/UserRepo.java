package com.blog.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.example.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
