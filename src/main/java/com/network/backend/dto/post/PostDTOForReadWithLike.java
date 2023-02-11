package com.network.backend.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Post;
import com.network.backend.repository.LikeRepository;
import com.network.backend.service.LikeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

@Data
public class PostDTOForReadWithLike extends PostDTO{

    private int likes;
    @ConstructorProperties({"id","image","postMessage","date"})
    public PostDTOForReadWithLike(long id,String imageId, String postMessage, LocalDateTime date){
        setId(id);
        setImagePath(imageId);
        setPostMessage(postMessage);
        setDate(date);
    }

    public PostDTOForReadWithLike(Post entity){
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
