package com.boot.bbs.springbbs.web;

import com.boot.bbs.springbbs.domain.post.Posts;
import com.boot.bbs.springbbs.web.dto.PostsResponseDto;
import com.boot.bbs.springbbs.web.dto.PostsSaveRequestDto;
import com.boot.bbs.springbbs.web.dto.PostsService;
import com.boot.bbs.springbbs.web.dto.PostsUpdateRequestDto;
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

    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

}
