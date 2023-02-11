package com.network.backend.controller;

import com.network.backend.dto.comment.CommentDTOForCreateOrRead;
import com.network.backend.dto.comment.CommentDTOForUpdate;
import com.network.backend.facade.CommentFasade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private CommentFasade commentFasade;

    public CommentController(CommentFasade commentFasade) {
        this.commentFasade = commentFasade;
    }

    @PostMapping("/")
    public ResponseEntity<CommentDTOForCreateOrRead> createComment(@Valid @RequestBody CommentDTOForCreateOrRead comment){
        return new ResponseEntity<>(commentFasade.createComment(comment), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTOForCreateOrRead> readComment(@PathVariable long id){
        return new ResponseEntity<>(commentFasade.readComment(id),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<CommentDTOForUpdate> updateComment(@Valid @RequestBody CommentDTOForUpdate comment){
        return new ResponseEntity<>(commentFasade.updateComment(comment),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable long id){
        commentFasade.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
