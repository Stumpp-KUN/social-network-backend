package com.network.backend.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Post;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

public class PostDTOForCreateOrRead extends PostDTO{
    @ConstructorProperties({"imagePath","postMessage","date"})
    public PostDTOForCreateOrRead(String imageId, String postMessage, LocalDateTime date){
        setImagePath(imageId);
        setPostMessage(postMessage);
        setDate(date);
    }

    public PostDTOForCreateOrRead(Post entity){
        setDate(entity.getDateTime());
        setImagePath(entity.getImage());
        setPostMessage(entity.getPostMessage());
    }

    @JsonIgnore
    public Post getEntity(){
        Post post=new Post();
        post.setPostMessage(this.getPostMessage());
        post.setDateTime(this.getDate());
        post.setImage(this.getImagePath());
        return post;
    }
}
