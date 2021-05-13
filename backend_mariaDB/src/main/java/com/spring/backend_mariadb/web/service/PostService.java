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

    @Transactional  //Transactional 쿼리에 문제생기면 자동 롤백해줌.
    public Long save(PostsDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long delete(Long id) {
        postsRepository.deleteById(id);
        return id;
    }
    @Transactional
    public Long put(Long id, PostsDto requestDto){
        postsRepository.findById(id).get();//id값 없으면 에러발생하기 위해서
        requestDto.setId(id);
        return postsRepository.save(requestDto.toPut()).getId();
    }
    @Transactional
    public Long patch(Long id, PostsDto requestDto){
        Posts post = postsRepository.findById(id).get();
        requestDto.setId(id);
        if(requestDto.getTitle()==null) requestDto.setTitle(post.getTitle());
        if(requestDto.getContent()==null) requestDto.setContent(post.getContent());
        if(requestDto.getAuthor()==null) requestDto.setAuthor(post.getAuthor());
        return postsRepository.save(requestDto.toPut()).getId();
    }
    @Transactional
    public PostsDto getPostbyId(Long id){
        Posts post=postsRepository.findById(id).get();
        return PostsDto.builder()
                .id(id)
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .build();
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