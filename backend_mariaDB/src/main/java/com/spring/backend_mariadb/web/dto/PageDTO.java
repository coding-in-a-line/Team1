package com.spring.backend_mariadb.web.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PageDTO<T> {
    private List<T> content;
    private Long totalElements;
    private int number;

    @Builder
    public PageDTO(List<T> content, Long totalElements, int number) {
        this.content=content;
        this.totalElements=totalElements;
        this.number=number;
    }
}
