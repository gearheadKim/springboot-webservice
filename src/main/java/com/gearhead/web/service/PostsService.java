package com.gearhead.web.service;

import com.gearhead.domain.post.Posts;
import com.gearhead.domain.post.PostsRepository;
import com.gearhead.web.dto.PostsDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Posts findById(Long id) {
        return postsRepository.findById(id).orElse(null);
    }

    @Transactional
    public Long insert(PostsDto postsDto) {
        return postsRepository.save( postsDto.toEntity() ).getId();
    }

    @Transactional
    public Long update(PostsDto postsDto, Long id) {
        Posts post = findById(id);
        post.update(postsDto);

        return post.getId();
    }

    @Transactional
    public void delete(PostsDto postsDto) {
        postsRepository.delete(postsDto.toEntity());
    }
}