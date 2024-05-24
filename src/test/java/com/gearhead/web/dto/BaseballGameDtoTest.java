package com.gearhead.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameDtoTest {
    @Test
    public void testHello(){
        String given = "123";
        String input = "321";

        BaseballGameDto dto = new BaseballGameDto(given, input);

        assertThat(dto.getGiven()).isEqualTo(given);
        assertThat(dto.getInput()).isEqualTo(input);
    }
}
