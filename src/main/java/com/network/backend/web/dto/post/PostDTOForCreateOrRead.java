package com.network.backend.web.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Post;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

public class PostDTOForCreateOrRead extends PostDTO{
    @ConstructorProperties({"postMessage","date","base64Image"})
    public PostDTOForCreateOrRead(String postMessage, LocalDateTime date, Users users,String base64Image){
        setPostMessage(postMessage);
        setDate(date);
        setUsers(users);
        setBase64image(base64Image);
    }

    public PostDTOForCreateOrRead(Post entity){
        setDate(entity.getDateTime());
        setPostMessage(entity.getPostMessage());
        setUsers(entity.getUsers());
        setBase64image(entity.getBase64image());
    }

    @JsonIgnore
    public Post getEntity(){
        Post post=new Post();
        post.setPostMessage(this.getPostMessage());
        post.setDateTime(this.getDate());
        post.setUsers(this.getUsers());
        post.setBase64image(this.getBase64image());
        return post;
    }
}
