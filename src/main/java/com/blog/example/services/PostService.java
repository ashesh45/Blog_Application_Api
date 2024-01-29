package com.blog.example.services;

import java.util.List;

import com.blog.example.entities.Post;
import com.blog.example.payloads.PostDto;

public interface PostService {
	
	//create
	Post createPost(PostDto postDto);
	
	//update
	Post updatePost(PostDto postDto, Integer postId);
	
	//delete
	Post deletePost(Integer postId);
	
	//get all posts
	List<Post> getAllPost();
	
	//get single post
	Post getPostById(Integer postId);
	
	//get all post by category
	List<Post> getPostByCategory(Integer category);
	
	//get all post by user
	List<Post> getPostByUser(Integer UserId);
	
	//searching post
	List<Post> searchPosts(String keyword);
	
}
