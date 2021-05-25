package com.spring.backend_mariadb.web.controller;

import com.spring.backend_mariadb.web.dto.ApiResult;
import com.spring.backend_mariadb.web.dto.PostsDto;
import com.spring.backend_mariadb.web.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins={"*"})
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostService postService;

    @GetMapping("/api/v1/posts")
    public ApiResult getPosts(@PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC, size = 10) Pageable pageable){
        try {
            return ApiResult.succeed(
                    postService.getPosts(pageable)
            );
        }
        catch (Exception e){
            log.error("Error",e);
            return ApiResult.failed(e);
        }
    }
    @GetMapping("/api/v1/posts/{id}")
    public ApiResult getPostbyId(@PathVariable Long id){
        try {
            return ApiResult.succeed(
                    postService.getPostbyId(id)
            );
        }catch (Exception e){
            log.error("Error",e);
            return ApiResult.failed(e);
        }
    }
    @PostMapping(value = "/api/v1/posts")
    public ApiResult save(@RequestBody PostsDto requestDto) {
        try {
            return ApiResult.succeed(
                    postService.save(requestDto)
            );
        }catch(Exception e){
            log.error("error",e);
            return ApiResult.failed(e);
        }
    }
    @PutMapping("/api/v1/posts/{id}")
    public ApiResult put(@PathVariable Long id,@RequestBody PostsDto requestDto) {
        try {
            return ApiResult.succeed(
                    postService.put(id, requestDto)
            );
        } catch (Exception e) {
            log.error("Error", e);
            return ApiResult.failed(e);
        }
    }
    @PatchMapping("/api/v1/posts/{id}")
    public ApiResult patch (@PathVariable Long id, @RequestBody PostsDto requestDto){
        try {
            return ApiResult.succeed(
                    postService.patch(id, requestDto)
            );
        } catch (Exception e) {
            log.error("Error", e);
            return ApiResult.failed(e);
        }
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public ApiResult delete(@PathVariable Long id){
        try {
            return ApiResult.succeed(
                    postService.delete(id)
            );
        } catch (Exception e) {
            log.error("Error", e);
            return ApiResult.failed(e);
        }
    }
}
