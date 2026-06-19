package com.blog.example.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.example.entities.Post;
import com.blog.example.entities.comment;
import com.blog.example.exceptions.ResourceNotFoundException;
import com.blog.example.payloads.CommentDto;
import com.blog.example.repositories.CommentRepo;
import com.blog.example.repositories.PostRepo;
import com.blog.example.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		Post post = this.postRepo.findById(postId)
		        .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
	
		 comment comment = this.modelMapper.map(commentDto, comment.class);

		    comment.setPost(post);

		    comment savedComment = this.commentRepo.save(comment);

		    return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
	    comment comment = this.commentRepo.findById(commentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Comment", "comment id", commentId));

	    this.commentRepo.delete(comment);
	}




}
