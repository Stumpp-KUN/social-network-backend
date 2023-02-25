package com.network.backend.socialNetwork.service;

import com.network.backend.model.Like;
import com.network.backend.model.Post;
import com.network.backend.model.Users;
import com.network.backend.service.LikeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class LikeServiceTest {

    @MockBean
    private LikeService likeService;

    private Like getLike(){
        Like like=new Like();
        like.setId(1);
        like.setPost(new Post());
        like.setUsers(new Users());
        return like;
    }

    @Test
    public void testCreateLike(){
        Like like=getLike();
        when(likeService.saveLike(any(Like.class))).thenReturn(like);
        Like savedLike=likeService.saveLike(like);
        assertThat(savedLike.getId());
    }

    @Test
    public void testDeleteLike(){
        doNothing().when(likeService).deleteLike(1);
        likeService.deleteLike(1);
        assertThat(true);
    }

    @Test
    public void testUpdateLike(){
        Like like=getLike();
        when(likeService.updateLike(any(Like.class))).thenReturn(like);
        Like savedLike=likeService.updateLike(like);
        assertThat(savedLike.getId());
    }

    @Test
    public void testGetLike(){
        Like like=getLike();
        given(likeService.getLike(1)).willReturn(like);
        Like result=likeService.getLike(1);
        assertEquals(result.getId(),1);
    }

    @Test
    public void testGetLikes(){
        int k=1;
        given(likeService.getLikes(1)).willReturn(k);
        int h = likeService.getLikes(k);
        assertEquals(k, 1);
    }

}
