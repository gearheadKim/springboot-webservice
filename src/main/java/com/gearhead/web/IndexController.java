package com.gearhead.web;

import com.gearhead.domain.post.Posts;
import com.gearhead.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.selectListDesc());
        return "index";
    }

    @GetMapping("/posts/list")
    public String selectList(Model model){
        model.addAttribute("posts", postsService.selectListSort());
        return "index";
    }

    @GetMapping("/posts/save")
    public String save(){
        return "posts-save";   // posts-save.mustache 화면 표시
    }

    @GetMapping("/posts/update/{id}")
    public String edit(Model model, @PathVariable Long id){
        model.addAttribute("post", postsService.select(id));
        return "posts-edit";   // posts-save.mustache 화면 표시
    }
}
