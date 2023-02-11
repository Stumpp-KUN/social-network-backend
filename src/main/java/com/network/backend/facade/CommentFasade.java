package com.network.backend.facade;

import com.network.backend.dto.comment.CommentDTO;
import com.network.backend.dto.comment.CommentDTOForCreateOrRead;
import com.network.backend.dto.comment.CommentDTOForUpdate;
import com.network.backend.exception.NoSuchComment;
import com.network.backend.model.Comment;
import com.network.backend.service.CommentService;
import org.springframework.stereotype.Component;

@Component
public class CommentFasade {

    private CommentService commentService;

    public CommentFasade(CommentService commentService) {
        this.commentService = commentService;
    }

    public CommentDTOForCreateOrRead createComment(CommentDTOForCreateOrRead comment){
        Comment comment1=commentService.createComment(getEntityByCreateOrReadDTO(comment));
        return getCRDTOByEntity(comment1);
    }

    private Comment getEntityByCreateOrReadDTO(CommentDTOForCreateOrRead comment){
        Comment comment1=comment.getEntity();
        return comment1;
    }

    private CommentDTOForCreateOrRead getCRDTOByEntity(Comment comment){
        CommentDTOForCreateOrRead commentDTOForCreateOrRead=new CommentDTOForCreateOrRead(comment);
        return commentDTOForCreateOrRead;
    }



    public CommentDTOForCreateOrRead readComment(long id){
        Comment comment=commentService.getComment(id);
        if(comment==null) throw new NoSuchComment("There is not comment with id "+id);
        return getCRDTOByEntity(comment);
    }

    public CommentDTOForUpdate updateComment(CommentDTOForUpdate update){
        Comment comment=commentService.updateComment(getEntityByUpdateDTO(update));
        return getUpdateDTOByEntity(comment);
    }

    private Comment getEntityByUpdateDTO(CommentDTOForUpdate update){
        Comment comment=update.getEntity();
        return comment;
    }

    private CommentDTOForUpdate getUpdateDTOByEntity(Comment comment){
        CommentDTOForUpdate commentDTOForUpdate=new CommentDTOForUpdate(comment);
        return commentDTOForUpdate;
    }


    public void deleteComment(long id){
        if(commentService.getComment(id)==null) throw new NoSuchComment("There is not comment with id "+id);
        commentService.deleteComment(id);
    }

}
