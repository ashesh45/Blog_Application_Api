package com.blog.example.services;

import java.util.List;

import com.blog.example.entities.Post;
import com.blog.example.payloads.PostDto;
import com.blog.example.payloads.PostResponse;

public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all posts
	PostResponse getAllPost(Integer pageNumber,Integer pageSize, String sortBy, String sortDir);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//searching post
	List<PostDto> searchPosts(String keyword);
	
}
