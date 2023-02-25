package com.network.backend.repository;

import com.network.backend.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
    Page<Post> findAllByUsers_Id(long id, Pageable pageable);
}
