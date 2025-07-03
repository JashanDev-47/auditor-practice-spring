package com.example.auditor.services;

import com.example.auditor.dtos.PostDto;

import java.util.List;

public interface PostService {


    List<PostDto> getAllPosts();

    PostDto createPost(PostDto postDto);

    PostDto updatePost(Long postId, PostDto postDto);
}
