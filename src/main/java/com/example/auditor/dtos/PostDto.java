package com.example.auditor.dtos;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long postId;

    @Size(min = 3,max = 10)
    private String title;
    private String description;



}
