package com.blog.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.example.entities.Post;
import com.blog.example.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> getByUser(User user);
	List<Post> getByCategory(User category);

}
