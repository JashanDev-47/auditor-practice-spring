package com.example.auditor.controllers;


import com.example.auditor.dtos.PostDto;
import com.example.auditor.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")

@RequiredArgsConstructor
public class PostController {

    private final PostService service;


    @GetMapping
    public List<PostDto> getAllPosts() {
        return service.getAllPosts();
    }


    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto) {
        return service.createPost(postDto);
    }


    @PutMapping("/{postId}")
    public PostDto updatePost(@RequestBody PostDto postDto, @PathVariable Long postId) {
        return service.updatePost(postId,postDto);
    }

}
