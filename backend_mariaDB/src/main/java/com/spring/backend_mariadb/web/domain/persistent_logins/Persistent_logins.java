package com.spring.backend_mariadb.web.domain.persistent_logins;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Persistent_logins {
    @Id
    @Column(columnDefinition = "VARCHAR(64) COLLATE 'utf8mb4_bin'")
    private String series;

    @Column(columnDefinition = "VARCHAR(64) NOT NULL COLLATE 'utf8mb4_bin'")
    private String username;

    @Column(columnDefinition = "VARCHAR(64) NOT NULL COLLATE 'utf8mb4_bin'")
    private String token;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime last_used;
}
