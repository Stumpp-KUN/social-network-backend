package com.network.backend.web.controller;

import com.network.backend.model.Post;
import com.network.backend.web.dto.post.PostDTOForCreateOrRead;
import com.network.backend.web.dto.post.PostDTOForReadWithLike;
import com.network.backend.web.dto.post.PostDTOForUpdate;
import com.network.backend.web.facade.PostFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostFacade postFacade;

    @PostMapping("/")
    public ResponseEntity<PostDTOForCreateOrRead> createPost(@Valid @RequestBody PostDTOForCreateOrRead post, String imagePath) throws IOException {
        return new ResponseEntity<>(postFacade.createPost(post), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTOForReadWithLike> getPost(@PathVariable long id){
        return new ResponseEntity<>(postFacade.readPost(id),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<PostDTOForUpdate> updatePost(@Valid @RequestBody PostDTOForUpdate post){
        return new ResponseEntity<>(postFacade.updatePostDTO(post),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable long id){
        postFacade.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Page<Post>> getPostsByUserId(@PathVariable long id,
                                                       @RequestParam(defaultValue = "0") Integer pageNo,
                                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                                       @RequestParam(defaultValue = "id") String sortBy){
        return new ResponseEntity<>(postFacade.getPosts(id,pageNo,pageSize,sortBy),HttpStatus.OK);

    }
}
