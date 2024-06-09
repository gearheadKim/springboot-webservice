package com.gearhead.web;

import com.gearhead.domain.post.Posts;
import com.gearhead.web.dto.PostsDto;
import com.gearhead.web.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostsApiController {

    @Autowired
    private PostsService postsService;

//    @GetMapping("/api/v1/posts")
//    public List<PostsDto> inqueryList(@RequestBody PostsDto requestDto ){
//        return postsService.findAll(requestDto);
//    }

    @GetMapping("/api/v1/posts/{id}")
    public Posts inquery(@PathVariable Long id){
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/save")
    public Long save(@RequestBody PostsDto requestDto){
        return postsService.insert(requestDto);
    }

    @GetMapping("/api/v1/posts/edit/{id}")
    public Long edit(@RequestBody PostsDto requestDto, @PathVariable Long id){
        return postsService.update(requestDto, id);
    }

    @GetMapping("/api/v1/posts/delete")
    public void delete(@RequestBody PostsDto requestDto){
        postsService.delete(requestDto);
    }
}