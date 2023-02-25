package com.network.backend.web.facade;

import com.network.backend.exception.EntityNotFoundException;
import com.network.backend.model.Image;
import com.network.backend.model.Post;
import com.network.backend.repository.ImageRepository;
import com.network.backend.service.LikeService;
import com.network.backend.service.PostService;
import com.network.backend.web.dto.post.PostDTOForCreateOrRead;
import com.network.backend.web.dto.post.PostDTOForReadWithLike;
import com.network.backend.web.dto.post.PostDTOForUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class PostFacade {
    private final PostService postService;
    private final LikeService likeService;
    private final ImageRepository imageRepository;

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
        if(postService.getPost(id)==null) throw new EntityNotFoundException("there is no post with id "+id);
        postService.deletePost(id);
    }

    public void saveImage(PostDTOForCreateOrRead postDTOForCreateOrRead, String path) throws IOException {
        byte[] decodedImg = Base64.getDecoder()
                .decode(path.getBytes(StandardCharsets.UTF_8));
        Path destinationFile = Paths.get("d:/p/", postDTOForCreateOrRead.getId()+".jpg");
        Files.write(destinationFile, decodedImg);
        Image image=new Image();
        image.setImgPath(path);
        image.setPostId(postDTOForCreateOrRead.getId());
        imageRepository.save(image);
    }

    public Page<Post> getPosts(long id,Integer pageNo, Integer pageSize, String sortBy){
        return postService.getPostsById(id,PageRequest.of(pageNo,pageSize, Sort.by(sortBy)));
    }
}
