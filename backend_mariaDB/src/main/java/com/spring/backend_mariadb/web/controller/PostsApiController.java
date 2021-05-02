package com.spring.backend_mariadb.web.controller;

import com.spring.backend_mariadb.web.dto.PostsDto;
import com.spring.backend_mariadb.web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostService postService;


    @GetMapping("/api/v1/posts")
    public List<PostsDto> getPosts(){
        return postService.getPosts();
    }
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsDto requestDto) {
        return postService.save(requestDto);
    }


}
