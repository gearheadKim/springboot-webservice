package com.gearhead.web;

import com.gearhead.BaseballGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseballGameController {
    @GetMapping("/play")
    public String play(){
        BaseballGame bg = new BaseballGame();

        return bg.getScore("123","321");
    }
}
