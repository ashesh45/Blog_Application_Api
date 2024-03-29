package com.blog.example.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.example.entities.Category;
import com.blog.example.entities.Post;
import com.blog.example.entities.User;
import com.blog.example.exceptions.ResourceNotFoundException;
import com.blog.example.payloads.PostDto;
import com.blog.example.payloads.PostResponse;
import com.blog.example.repositories.CategoryRepo;
import com.blog.example.repositories.PostRepo;
import com.blog.example.repositories.UserRepo;
import com.blog.example.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
//create post
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User id",userId));
		
		Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category id",categoryId));
		
		Post post = this.modelmapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		
		Post newPost = this.postRepo.save(post);
		return this.modelmapper.map(newPost,PostDto.class);
		
	}

@Override
public PostDto updatePost(PostDto postDto, Integer postId) {
	 Post post = this.postRepo.findById(postId)
             .orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

     Category category = this.categoryRepo.findById(postDto.getCategory().getCategoryId()).get();

     post.setTitle(postDto.getTitle());
     post.setContent(postDto.getContent());
     post.setImageName(postDto.getImageName());
     post.setCategory(category);


     Post updatedPost = this.postRepo.save(post);
     return this.modelmapper.map(updatedPost, PostDto.class);
}

@Override
public void deletePost(Integer postId) {
	 Post post = this.postRepo.findById(postId)
             .orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

     this.postRepo.delete(post);
}

@Override
public List<PostDto> getAllPost() {
	 List<Post> allPosts = this.postRepo.findAll();
	 List<PostDto> postDtos = allPosts.stream().map((post) -> this.modelmapper.map(post, PostDto.class))
             .collect(Collectors.toList());
	return postDtos;
}

@Override
public PostDto getPostById(Integer postId) {
	 Post post = this.postRepo.findById(postId)
             .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
     return this.modelmapper.map(post, PostDto.class);
}

@Override
public List<PostDto> getPostsByCategory(Integer categoryId) {
	Category category = this.categoryRepo.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
    List<Post> posts = this.postRepo.findByCategory(category);

    List<PostDto> postDtos = posts.stream().map((post) -> this.modelmapper.map(post, PostDto.class))
            .collect(Collectors.toList());

    return postDtos;
}

@Override
public List<PostDto> getPostsByUser(Integer userId) {
	 User user = this.userRepo.findById(userId)
             .orElseThrow(() -> new ResourceNotFoundException("User ", "userId ", userId));
     List<Post> posts = this.postRepo.findByUser(user);

     List<PostDto> postDtos = posts.stream().map((post) -> this.modelmapper.map(post, PostDto.class))
             .collect(Collectors.toList());

     return postDtos;
}

@Override
public List<PostDto> searchPosts(String keyword) {
	   List<Post> posts = this.postRepo.searchByTitle("%" + keyword + "%");
       List<PostDto> postDtos = posts.stream().map((post) -> this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
       return postDtos;
}

}	

