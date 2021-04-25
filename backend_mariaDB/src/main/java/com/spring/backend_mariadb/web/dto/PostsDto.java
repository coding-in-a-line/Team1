package com.spring.backend_mariadb.web.dto;

import com.spring.backend_mariadb.web.domain.posts.Posts;
import lombok.Builder;
import lombok.Data;

@Data
public class PostsDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsDto(Long id,String title, String content,
                               String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
