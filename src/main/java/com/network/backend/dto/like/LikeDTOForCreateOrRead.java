package com.network.backend.dto.like;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Like;
import com.network.backend.model.Post;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;

public class LikeDTOForCreateOrRead extends LikeDTO{
    @ConstructorProperties({"user","post"})
    public LikeDTOForCreateOrRead(Users users, long post){
        setPost(post);
        setUsers(users);
    }

    public LikeDTOForCreateOrRead(Like like){
        setUsers(like.getUsers());
        setPost(like.getPost_id());
    }

    @JsonIgnore
    public Like getEntity() {
        Like like = new Like();
        like.setPost_id(this.getPost());
        like.setUsers(this.getUsers());
        return like;
    }
}
