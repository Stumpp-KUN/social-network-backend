package com.network.backend.web.dto.like;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Like;
import com.network.backend.model.Post;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;

public class LikeDTOForUpdate extends LikeDTO{
    @ConstructorProperties({"id","user","post"})
    public LikeDTOForUpdate(long id, Users users, Post post){
        setId(id);
        setUsers(users);
        setPost(post);
    }

    public LikeDTOForUpdate(Like like){
        setId(like.getId());
        setUsers(like.getUsers());
        setPost(like.getPost());
    }

    @JsonIgnore
    public Like getEntity(){
        Like like=new Like();
        like.setId(this.getId());
        like.setUsers(this.getUsers());
        like.setPost(this.getPost());
        return like;
    }
}
