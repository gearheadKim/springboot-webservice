package com.gearhead.web;

import com.gearhead.domain.post.Posts;
import com.gearhead.web.dto.PostsDto;
import com.gearhead.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostsApiController {

    @Autowired
    private PostsService postsService;

    @GetMapping("/api/v1/posts/{id}")
    public Posts select(@PathVariable Long id){
        return postsService.select(id);
    }

    @PostMapping("/api/v1/posts")
    public Long insert(@RequestBody PostsDto requestDto){
        return postsService.insert(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@RequestBody PostsDto requestDto, @PathVariable Long id){
        return postsService.update(requestDto, id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}