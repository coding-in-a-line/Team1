package com.spring.backend_mariadb.web.controller;

import com.spring.backend_mariadb.web.dto.ApiResult;
import com.spring.backend_mariadb.web.dto.LoginDto;
import com.spring.backend_mariadb.web.dto.MembersDto;
import com.spring.backend_mariadb.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.spring.backend_mariadb.web.dto.ApiResult.failed;
import static com.spring.backend_mariadb.web.dto.ApiResult.succeed;

@RequiredArgsConstructor
@RestController
@Slf4j
public class MembersApiController {
    private final MemberService memberService;

    @PostMapping("/api/signup")
    public ApiResult save(@RequestBody MembersDto requestDto) {
        try {
            return succeed(
                    memberService.save(requestDto)
            );
        }catch (Exception e){
            log.error("Error",e);
            return failed(e);
        }
    }
    @GetMapping("/api/member")
    public ApiResult getMembers(){
        return succeed(
                memberService.getMembers()
        );
    }
    @GetMapping("/api/login")
    public ApiResult Auth(@RequestBody LoginDto params){
        return succeed(
                memberService.Auth(params.getId(),params.getPw())
        );
    }

}
