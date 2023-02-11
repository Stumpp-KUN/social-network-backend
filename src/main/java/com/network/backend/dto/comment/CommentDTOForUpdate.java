package com.network.backend.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Comment;
import com.network.backend.model.Post;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

public class CommentDTOForUpdate extends CommentDTO{
    @ConstructorProperties({"id","message", "time","user","post"})
    public CommentDTOForUpdate(long id, String message, LocalDateTime time, Users users, Post post){
        setId(id);
        setMessage(message);
        setDate(time);
        setUsers(users);
        setPost(post);
    }

    public CommentDTOForUpdate(Comment entity){
        setId(entity.getId());
        setMessage(entity.getMessage());
        setDate(entity.getDate());
        setUsers(entity.getUsers());
        setPost(entity.getPost());
    }

    @JsonIgnore
    public Comment getEntity(){
        Comment comment=new Comment();
        comment.setId(this.getId());
        comment.setMessage(this.getMessage());
        comment.setDate(this.getDate());
        comment.setUsers(this.getUsers());
        comment.setPost(this.getPost());
        return comment;
    }
}
