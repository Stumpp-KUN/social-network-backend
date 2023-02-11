package com.network.backend.controller;

import com.network.backend.dto.post.PostDTOForCreateOrRead;
import com.network.backend.dto.post.PostDTOForReadWithLike;
import com.network.backend.dto.post.PostDTOForUpdate;
import com.network.backend.facade.PostFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    private PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    @PostMapping("/")
    public ResponseEntity<PostDTOForCreateOrRead> createPost(@Valid @RequestBody PostDTOForCreateOrRead post){
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
}
