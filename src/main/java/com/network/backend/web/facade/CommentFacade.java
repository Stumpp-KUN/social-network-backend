package com.network.backend.web.facade;

import com.network.backend.web.dto.comment.CommentDTOForCreateOrRead;
import com.network.backend.web.dto.comment.CommentDTOForUpdate;
import com.network.backend.exception.EntityNotFoundException;
import com.network.backend.model.Comment;
import com.network.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentService commentService;

    public CommentDTOForCreateOrRead createComment(CommentDTOForCreateOrRead comment){
        Comment comment1=commentService.createComment(getEntityByCreateOrReadDTO(comment));
        return getCRDTOByEntity(comment1);
    }

    public Comment getEntityByCreateOrReadDTO(CommentDTOForCreateOrRead comment){
        Comment comment1=comment.getEntity();
        return comment1;
    }

    public CommentDTOForCreateOrRead getCRDTOByEntity(Comment comment){
        CommentDTOForCreateOrRead commentDTOForCreateOrRead=new CommentDTOForCreateOrRead(comment);
        return commentDTOForCreateOrRead;
    }



    public CommentDTOForCreateOrRead readComment(long id){
        Comment comment=commentService.getComment(id);
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
        if(commentService.getComment(id)==null) throw new EntityNotFoundException("There is not comment with id "+id);
        commentService.deleteComment(id);
    }

}
