package com.spring.backend_mariadb.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
