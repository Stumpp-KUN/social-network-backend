package com.network.backend.socialNetwork.service;

import com.network.backend.model.Comment;
import com.network.backend.model.Post;
import com.network.backend.model.Users;
import com.network.backend.service.CommentService;
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
public class CommentServiceTest {

    @MockBean
    private CommentService commentService;

    @Test
    public void testCreateComment(){
        Comment comment=getComment();

        when(commentService.createComment(any(Comment.class))).thenReturn(comment);

        Comment savedComment=commentService.createComment(comment);
        assertThat(!savedComment.getMessage().isBlank());

    }

    @Test
    public void testDeleteComment(){
        doNothing().when(commentService).deleteComment(1);
        commentService.deleteComment(1);
        assertThat(true);
    }

    @Test
    public void testUpdateComment(){
        Comment comment=getComment();
        when(commentService.updateComment(any(Comment.class))).thenReturn(comment);
        Comment updatedComment=commentService.updateComment(comment);
        assertThat(!updatedComment.getMessage().isBlank());
    }

    @Test
    public void testGetComment(){
        Comment comment=getComment();
        given(commentService.getComment(1)).willReturn(comment);
        Comment result = commentService.getComment(1);
        assertEquals(result.getId(), 1);
    }

    private Comment getComment(){
        Comment comment=new Comment();
        comment.setId(1);
        comment.setMessage("test");
        comment.setPost(new Post());
        comment.setUsers(new Users());
        return comment;
    }



}
