package com.network.backend.socialNetwork.service;

import com.network.backend.model.Post;
import com.network.backend.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PostServiceTest {
    @MockBean
    private PostService postService;

    public Post getPost(){
        Post post=new Post();
        post.setId(1);
        post.setPostMessage("test");
        return post;
    }

    @Test
    public void testCreatePost(){
        Post post=getPost();
        when(postService.savePost(any(Post.class))).thenReturn(post);
        Post post1=postService.savePost(post);
        assertThat(!post1.getPostMessage().isBlank());
    }

    @Test
    public void testDeletePost(){
        doNothing().when(postService).deletePost(1);
        postService.deletePost(1);
        assertThat(true);
    }

    @Test
    public void testUpdatePost(){
        Post post=getPost();
        when(postService.updatePost(any(Post.class))).thenReturn(post);
        Post post1=postService.updatePost(post);
        assertThat(!post1.getPostMessage().isBlank());
    }

    @Test
    public void testGetPost(){
        Post post=getPost();
        given(postService.getPost(1)).willReturn(post);
        Post post1=postService.getPost(1);
        assertEquals(post1.getId(),1);
    }
}
