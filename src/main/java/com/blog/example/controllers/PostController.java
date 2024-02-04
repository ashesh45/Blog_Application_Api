package com.blog.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.example.payloads.PostDto;
import com.blog.example.services.PostService;



@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			                                  @RequestBody PostDto postDto,
			                                  @PathVariable Integer userId,
			                                  @PathVariable Integer category
                                               )
	{
		PostDto createPost = this.postService.createPost(postDto, userId, category);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);

}
}