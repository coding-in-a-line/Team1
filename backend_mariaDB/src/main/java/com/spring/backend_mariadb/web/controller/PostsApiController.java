package com.spring.backend_mariadb.web.controller;

import com.spring.backend_mariadb.web.dto.ApiResult;
import com.spring.backend_mariadb.web.dto.PostsDto;
import com.spring.backend_mariadb.web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostService postService;

    @GetMapping("/api/posts")
    public ApiResult getPosts(@PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC, size = 10)
                                  Pageable pageable){
        return ApiResult.succeed(
                postService.getPosts(pageable)
        );
    }
    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsDto requestDto) {
        return postService.save(requestDto);
    }
}
