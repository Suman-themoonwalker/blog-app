package com.app.blog.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.dto.PostDTO;
import com.app.blog.entity.Post;
import com.app.blog.repository.PostRepository;
import com.app.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	public PostDTO mapToDTO(Post newPost) {
		PostDTO pDto = new PostDTO();
		pDto.setId(newPost.getId());
		pDto.setTitle(newPost.getTitle());
		pDto.setContent(newPost.getContent());
		pDto.setDescription(newPost.getDescription());
		
		return pDto;
	}
	
	@Override
	public PostDTO createPost(PostDTO postDto) {
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		
		Post newPost = postRepo.save(post);
		
		PostDTO pDto = mapToDTO(newPost);
		
		return pDto;
	}

	@Override
	public List<PostDTO> getAllPosts() {
		List<Post> posts = postRepo.findAll();
		
		List<PostDTO> newPosts = new ArrayList<>();
		for(Post post: posts) {
			PostDTO newPost = mapToDTO(post);
			newPosts.add(newPost);
		}
		
		return newPosts;
	}

	@Override
	public PostDTO getPost(int id) {
		Post post = postRepo.findById(id).orElseThrow();
		
		PostDTO newPost = mapToDTO(post);		
		return newPost;
	}

	@Override
	public PostDTO deletePost(int id) {
		Post post = postRepo.findById(id).orElseThrow();
		
		PostDTO newPost = mapToDTO(post);		
		postRepo.deleteById(post.getId());
		
		return newPost;
	}

	@Override
	public PostDTO updatePost(PostDTO postDTO) {
		Post post = postRepo.findById(postDTO.getId()).orElseThrow();
		
		post.setId(postDTO.getId());
		post.setContent(postDTO.getContent());
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		
		postRepo.save(post);
		
		PostDTO newPostDTO = mapToDTO(post);
		
		return newPostDTO;
	}
}
