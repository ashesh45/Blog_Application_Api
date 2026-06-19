package com.blog.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.example.entities.comment;

public interface CommentRepo extends JpaRepository<comment,Integer> {

}
