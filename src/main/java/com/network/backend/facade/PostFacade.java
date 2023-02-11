package com.network.backend.facade;

import com.network.backend.dto.post.PostDTOForCreateOrRead;
import com.network.backend.dto.post.PostDTOForReadWithLike;
import com.network.backend.dto.post.PostDTOForUpdate;
import com.network.backend.exception.NoSuchPost;
import com.network.backend.model.Post;
import com.network.backend.repository.LikeRepository;
import com.network.backend.service.LikeService;
import com.network.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostFacade {
    private PostService postService;
    private LikeService likeService;

    public PostFacade(PostService postService, LikeService likeService) {
        this.postService = postService;
        this.likeService = likeService;
    }

    public PostDTOForCreateOrRead createPost(PostDTOForCreateOrRead post){
        Post post1=postService.savePost(getEntityByCreateOrReadDTO(post));
        return createOrReadPostDTO(post1);
    }

    private Post getEntityByCreateOrReadDTO(PostDTOForCreateOrRead post){
        Post post1=post.getEntity();
        return post1;
    }

    private PostDTOForCreateOrRead createOrReadPostDTO(Post post){
        PostDTOForCreateOrRead postDTOForCreateOrRead=new PostDTOForCreateOrRead(post);
        return postDTOForCreateOrRead;
    }



    public PostDTOForReadWithLike readPost(long id){
        Post post=postService.getPost(id);
        if(post==null) throw new NoSuchPost("There is no post with this id");
        PostDTOForReadWithLike postDTOForReadWithLike=getDTOWithLike(post);
        postDTOForReadWithLike.setLikes(likeService.getLikes(postDTOForReadWithLike.getId()));
        return postDTOForReadWithLike;
    }

    private PostDTOForReadWithLike getDTOWithLike(Post post){
        PostDTOForReadWithLike postDTOForReadWithLike=new PostDTOForReadWithLike(post);
        return postDTOForReadWithLike;
    }



    public PostDTOForUpdate updatePostDTO(PostDTOForUpdate upd){
        Post post=postService.updatePost(getEntityByUpdDTO(upd));
        return getUpdDTOByEntity(post);
    }

    private Post getEntityByUpdDTO(PostDTOForUpdate post){
        Post post1=post.getEntity();
        return post1;
    }

    private PostDTOForUpdate getUpdDTOByEntity(Post post){
        PostDTOForUpdate postDTOForUpdate=new PostDTOForUpdate(post);
        return postDTOForUpdate;
    }

    public void deletePost(long id) {
        if(postService.getPost(id)==null) throw new NoSuchPost("there is no post with id "+id);
        postService.deletePost(id);

    }
}
