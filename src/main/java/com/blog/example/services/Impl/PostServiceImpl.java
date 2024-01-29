package com.blog.example.services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.example.entities.Post;
import com.blog.example.payloads.PostDto;
import com.blog.example.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Override
	public Post createPost(PostDto postDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post deletePost(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByCategory(Integer category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByUser(Integer UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
