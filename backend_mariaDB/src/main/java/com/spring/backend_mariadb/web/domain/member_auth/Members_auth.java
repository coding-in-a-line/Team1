package com.spring.backend_mariadb.web.domain.member_auth;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Members_auth {

    @Id
    private Long i;

    @Column(columnDefinition = "INT(5) NOT NULL")
    private Long idx;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL COLLATE 'utf8mb4_bin'")
    private String id;
}
