package com.boot.bbs.springbbs.web;

import com.boot.bbs.springbbs.domain.post.Posts;
import com.boot.bbs.springbbs.web.dto.PostsSaveRequestDto;
import com.boot.bbs.springbbs.web.dto.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

}
