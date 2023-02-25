package com.network.backend.web.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Post;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

public class PostDTOForUpdate extends PostDTO{
    @ConstructorProperties({"id","postMessage","date"})
    public PostDTOForUpdate(long id, String image, String postMessage, LocalDateTime date, Users users,String base64Image){
        setId(id);
        setPostMessage(postMessage);
        setDate(date);
        setUsers(users);
        setBase64image(base64Image);
    }

    public PostDTOForUpdate(Post entity){
        setId(entity.getId());
        setDate(entity.getDateTime());
        setPostMessage(entity.getPostMessage());
        setUsers(entity.getUsers());
        setBase64image(entity.getBase64image());
    }

    @JsonIgnore
    public Post getEntity(){
        Post post=new Post();
        post.setId(this.getId());
        post.setPostMessage(this.getPostMessage());
        post.setDateTime(this.getDate());
        post.setUsers(this.getUsers());
        post.setBase64image(this.getBase64image());
        return post;
    }
}
