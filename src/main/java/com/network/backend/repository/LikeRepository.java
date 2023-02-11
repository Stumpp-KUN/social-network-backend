package com.network.backend.repository;

import com.network.backend.model.Like;
import com.network.backend.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends CrudRepository<Like,Long> {
    @Query("select count(m) from Like m where m.post_id=?1")
    int findAllByPost_id(long id);
}
