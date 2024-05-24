package com.gearhead.web;

import com.gearhead.BaseballGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class BaseballGameControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void play() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/play"))
                .andExpect(status().isOk());

        BaseballGame bg = new BaseballGame();

        assertThat(bg.getScore("123","321")).isEqualTo("(OUTPUT) 1S2B");
        assertThat(bg.getScore("123","415")).isEqualTo("(OUTPUT) 1B");
        assertThat(bg.getScore("123","123")).isEqualTo("(OUTPUT) 3S");
        assertThat(bg.getScore("123","456")).isEqualTo("(OUTPUT) (null)");
    }
}

