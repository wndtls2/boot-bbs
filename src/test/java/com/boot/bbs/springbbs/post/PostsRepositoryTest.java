package com.boot.bbs.springbbs.post;
import static org.assertj.core.api.Assertions.assertThat;
import com.boot.bbs.springbbs.domain.post.Posts;
import com.boot.bbs.springbbs.domain.post.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void posts_save_read(){
        //given
        String title ="테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                                    .title(title)
                                    .content(content)
                                    .author("wndtls2@naver.com")
                                    .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntity_reg(){
        //given
        LocalDateTime now = LocalDateTime.of(2021,5,1,0,0);
        postsRepository.save(Posts.builder()
                        .title("title")
                        .content("content1")
                        .build());

        //when
        List<Posts> list = postsRepository.findAll();

        //then
        Posts posts = list.get(0);
        System.out.println(">>>>>>>>>> createDT" + posts.getCreateDate());
        System.out.println(">>>>>>>>>> modiDT" + posts.getModifiedDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }

}

