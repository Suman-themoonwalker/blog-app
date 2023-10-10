package com.app.blog.service;

import java.util.List;

import com.app.blog.dto.PostDTO;

public interface PostService {
	public PostDTO createPost(PostDTO post);
	
	public List<PostDTO> getAllPosts();
	
	public PostDTO getPost(int id);

	public PostDTO deletePost(int id);

	public PostDTO updatePost(PostDTO post);
}
