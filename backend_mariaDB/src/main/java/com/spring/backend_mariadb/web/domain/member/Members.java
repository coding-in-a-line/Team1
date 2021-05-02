package com.spring.backend_mariadb.web.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(5)")
    private Long idx;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL UNIQUE COMMENT 'ID' COLLATE 'utf8mb4_bin'")
    private String id;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL COMMENT 'ID' COLLATE 'utf8mb4_bin'")
    private String pw;

    @Column(columnDefinition = "VARCHAR(10) NOT NULL COMMENT '본명' COLLATE 'utf8mb4_bin'")
    private String real_name;

    @Column(columnDefinition = "VARCHAR(30) NULL DEFAULT NULL COMMENT '주민번호' COLLATE 'utf8mb4_bin'")
    private String ctz_number;

    @Column(columnDefinition = "CHAR(1) NOT NULL DEFAULT '1' COMMENT '로그인 활성/비활성' COLLATE 'utf8mb4_bin'")
    private String login_status;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일'")
    private LocalDateTime reg_date;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일'")
    private LocalDateTime upd_date;

    @Column(columnDefinition = "VARCHAR(10) NULL DEFAULT NULL COMMENT '담당자' COLLATE 'utf8mb4_bin'")
    private String manager;

    @Builder
    public Members(Long idx, String id, String pw, String real_name, String ctz_number, String login_status, LocalDateTime reg_date, LocalDateTime upd_date,String manager) {
        this.idx = idx;
        this.id = id;
        this.pw = pw;
        this.real_name = real_name;
        this.ctz_number = ctz_number;
        this.login_status = login_status;
        this.reg_date = reg_date;
        this.upd_date = upd_date;
        this.manager = manager;
    }
}
