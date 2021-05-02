package com.spring.backend_mariadb.web.dto;

import com.spring.backend_mariadb.web.domain.member.Members;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MembersDto {
    private Long idx;
    private String id;
    private String pw;
    private String real_name;
    private String ctz_number;
    private String login_status;
    private LocalDateTime reg_date;
    private LocalDateTime upd_date;
    private String manager;

    @Builder
    public MembersDto(Long idx, String id, String pw, String real_name, String ctz_number, String login_status, LocalDateTime reg_date, LocalDateTime upd_date,String manager) {
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
    public Members toEntity() {
        return Members.builder()
                .id(id)
                .pw(pw)
                .real_name(real_name)
                .ctz_number(ctz_number)
                .login_status(login_status)
                .reg_date(reg_date)
                .upd_date(upd_date)
                .manager(manager)
                .build();
    }
}
