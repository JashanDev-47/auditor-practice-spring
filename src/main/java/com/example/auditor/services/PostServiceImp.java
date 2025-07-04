package com.example.auditor.services;

import com.example.auditor.dtos.PostDto;
import com.example.auditor.entities.PostEntity;
import com.example.auditor.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {


    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<PostDto> getAllPosts() {

        List<PostEntity> postEntities = postRepository.findAll();

        return postEntities.stream().map(
                postEntity -> modelMapper.map(postEntity, PostDto.class)

        ).toList();
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        PostEntity entity = modelMapper.map(postDto, PostEntity.class);
        entity = postRepository.save(entity);
        return modelMapper.map(entity, PostDto.class);
    }

    @Override
    public PostDto updatePost(Long postId, PostDto postDto) {
        postDto.setPostId(postId);
        PostEntity entity = modelMapper.map(postDto, PostEntity.class);
//        entity = postRepository.save(entity);
        return modelMapper.map(postRepository.save(entity), PostDto.class);
    }
}
