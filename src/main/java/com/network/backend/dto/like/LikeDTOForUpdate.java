package com.network.backend.dto.like;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Like;
import com.network.backend.model.Post;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;

public class LikeDTOForUpdate extends LikeDTO{
    @ConstructorProperties({"id","user","post"})
    public LikeDTOForUpdate(long id, Users users, long post){
        setId(id);
        setUsers(users);
        setPost(post);
    }

    public LikeDTOForUpdate(Like like){
        setId(like.getId());
        setUsers(like.getUsers());
        setPost(like.getPost_id());
    }

    @JsonIgnore
    public Like getEntity(){
        Like like=new Like();
        like.setId(this.getId());
        like.setUsers(this.getUsers());
        like.setPost_id(this.getPost());
        return like;
    }
}
