package com.blog.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.example.entities.Category;
import com.blog.example.entities.Post;
import com.blog.example.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);


}
