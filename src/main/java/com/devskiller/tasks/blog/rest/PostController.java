package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.service.PostService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;
	private final CommentService commentService;


	public PostController(PostService postService, CommentService commentService) {
		this.postService = postService;
		this.commentService = commentService;
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PostDto getPost(@PathVariable Long id) {
		return postService.getPost(id);
	}

	@GetMapping(value = "/{id}/comments")
	public List<CommentDto> getComments(@PathVariable(value = "id" ) Long id){
		return this.commentService.getCommentsForPost(id);
	}

	@PostMapping(value = "/{id}/comments")
	public Long saveComment(@PathVariable(value = "id") Long id, NewCommentDto newCommentDto){
		return this.commentService.addComment(newCommentDto);
	}

}
