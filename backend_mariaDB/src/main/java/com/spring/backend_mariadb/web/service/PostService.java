package com.spring.backend_mariadb.web.service;

import com.spring.backend_mariadb.web.domain.posts.Posts;
import com.spring.backend_mariadb.web.domain.posts.PostsRepository;
import com.spring.backend_mariadb.web.dto.PageDTO;
import com.spring.backend_mariadb.web.dto.PostsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public PageDTO<Object> getPosts(Pageable pageable){
        Page<Posts> postsPage = postsRepository.findAll(pageable);
        List<Object> postsDtoList = new ArrayList<>();
        for(Posts posts : postsPage.getContent()){
            postsDtoList.add(
                    PostsDto.builder()
                            .id(posts.getId())
                            .title(posts.getTitle())
                            .content(posts.getContent())
                            .author(posts.getAuthor())
                            .build()
            );
        }
        return PageDTO.builder()
                .content(postsDtoList)
                .totalElements(postsPage.getTotalElements())
                .number(postsPage.getNumber())
                .build();
    }
}