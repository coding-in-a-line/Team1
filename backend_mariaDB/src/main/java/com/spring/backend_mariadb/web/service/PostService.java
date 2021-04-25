package com.spring.backend_mariadb.web.service;

import com.spring.backend_mariadb.web.domain.posts.Posts;
import com.spring.backend_mariadb.web.domain.posts.PostsRepository;
import com.spring.backend_mariadb.web.dto.PostsDto;
import lombok.RequiredArgsConstructor;
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
    public List<PostsDto> getPosts(){
        List<Posts> postsList = postsRepository.findAll();
        List<PostsDto> postsDtoList = new ArrayList<>();
        for(Posts post : postsList){
            postsDtoList.add(
                    PostsDto.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .content(post.getContent())
                            .author(post.getAuthor())
                            .build()
            );
        }
        return postsDtoList;
    }

}