package com.network.backend.repository;

import com.network.backend.model.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like,Long> {
    int countLikesByPost_Id(long id);
}
