package com.network.backend.service;

import com.network.backend.exception.NoSuchComment;
import com.network.backend.model.Comment;
import com.network.backend.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional
    public Comment createComment(Comment comment){
       return commentRepository.save(comment);
    }

    @Transactional
    public Comment getComment(long id){
        Optional<Comment> comment=commentRepository.findById(id);
        if(comment.isEmpty()) return null;
        return comment.get();
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
