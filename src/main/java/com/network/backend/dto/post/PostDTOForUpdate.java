package com.network.backend.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Post;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

public class PostDTOForUpdate extends PostDTO{
    @ConstructorProperties({"id","image","postMessage","date"})
    public PostDTOForUpdate(long id,String image, String postMessage, LocalDateTime date){
        setId(id);
        setImagePath(image);
        setPostMessage(postMessage);
        setDate(date);
    }

    public PostDTOForUpdate(Post entity){
        setId(entity.getId());
        setDate(entity.getDateTime());
        setImagePath(entity.getImage());
        setPostMessage(entity.getPostMessage());
    }

    @JsonIgnore
    public Post getEntity(){
        Post post=new Post();
        post.setId(this.getId());
        post.setPostMessage(this.getPostMessage());
        post.setDateTime(this.getDate());
        post.setImage(this.getImagePath());
        return post;
    }
}
