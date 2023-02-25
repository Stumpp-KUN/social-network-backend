package com.network.backend.repository;

import com.network.backend.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,Long> {

}
