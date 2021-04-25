package com.spring.backend_mariadb.web.dto;

import lombok.Data;

@Data
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
