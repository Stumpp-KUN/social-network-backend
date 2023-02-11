package com.network.backend.repository;

import com.network.backend.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,Long> {
}
