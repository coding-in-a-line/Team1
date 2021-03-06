package com.spring.backend_mariadb.web.controller;

import com.spring.backend_mariadb.web.dto.HelloResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        log.info("hello");
        try{
            throw new NullPointerException();
        }catch(Exception e){
            log.info(e.toString());
        }
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,@RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
