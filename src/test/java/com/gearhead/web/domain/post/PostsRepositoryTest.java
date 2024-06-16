package com.gearhead.web.domain.post;

import com.gearhead.domain.post.Posts;
import com.gearhead.domain.post.PostsRepository;
import com.gearhead.web.dto.PostsDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("게시글저장_불러오기 테스트")
    public void test_savePost(){

        //given
        String title = "테스트 제목";
        String content = "테스트 본문";

        postsRepository.save( Posts.builder()
                .title(title)
                .content(content)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    @DisplayName("게시글저장_한건조회 테스트")
    public void test_searchPost(){
        //given
        String title = "테스트 제목";
        String content = "테스트 본문";

         Long id = postsRepository.save( Posts.builder()
                .title(title)
                .content(content)
                .build()).getId();

        //when
        Posts post = postsRepository.findById(id).orElse(null);

        //then
        assertThat(post).isNotNull();
        assertThat(post.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("게시글저장_삭제 테스트")
    public void test_deletePost(){

        //given
        String title = "테스트 제목";
        String content = "테스트 본문";

        Posts entity = Posts.builder()
                .title(title)
                .content(content)
                .build();

        Long id = postsRepository.save(entity).getId();

        //when
        postsRepository.delete(entity);

        Posts post = postsRepository.findById(id).orElse(null);

        //then
        assertThat(post).isNull();
    }

    @Test
    @DisplayName("생성시간/수정시간 자동화하기 테스트")
    public void test_baseTimeEntityPost(){

        //given
        LocalDateTime now = LocalDateTime.now();

        String title = "테스트 제목";
        String content = "테스트 본문";
        String author = "테스트 저자";

        postsRepository.save( Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts post = postsList.get(0);

        System.out.println(">>>>>>>>>> nowDate="+now);
        System.out.println(">>>>>>>>>> CreateDate="+post.getCreatedDate()+", modifiedDate="+post.getModifiedDate() );

        assertThat( post.getCreatedDate() ).isAfter(now);
        assertThat( post.getModifiedDate() ).isAfter(now);
    }

}
