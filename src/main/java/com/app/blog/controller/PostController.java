package com.app.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.blog.dto.PostDTO;
import com.app.blog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO post){
		return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<PostDTO>> getAllPosts(){
		return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> getPost(@PathVariable int id){
		return new ResponseEntity<>(postService.getPost(id),HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO post){
		return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PostDTO> deletePost(@PathVariable int id){
		return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
	}
}
