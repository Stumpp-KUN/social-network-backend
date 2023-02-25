package com.network.backend.service;

import com.network.backend.model.exception.NoSuchComment;
import com.network.backend.model.Comment;
import com.network.backend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Comment createComment(Comment comment){
       return commentRepository.save(comment);
    }


    public Comment getComment(long id){
        return commentRepository.findById(id).orElseThrow(()->new NoSuchComment("There is not comment with id "+ id ));
    }

    @Transactional
    public Comment updateComment(Comment comment){
        return commentRepository.save(comment);
    }
    @Transactional
    public void deleteComment(long id){
        commentRepository.deleteById(id);
    }
}
