package com.network.backend.web.controller;

import com.network.backend.web.dto.comment.CommentDTOForCreateOrRead;
import com.network.backend.web.dto.comment.CommentDTOForUpdate;
import com.network.backend.web.facade.CommentFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentFacade commentFacade;

    @PostMapping("/")
    public ResponseEntity<CommentDTOForCreateOrRead> createComment(@Valid @RequestBody CommentDTOForCreateOrRead comment){
        return new ResponseEntity<>(commentFacade.createComment(comment), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTOForCreateOrRead> readComment(@PathVariable long id){
        return new ResponseEntity<>(commentFacade.readComment(id),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<CommentDTOForUpdate> updateComment(@Valid @RequestBody CommentDTOForUpdate comment){
        return new ResponseEntity<>(commentFacade.updateComment(comment),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable long id){
        commentFacade.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
