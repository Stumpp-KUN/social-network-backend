package com.network.backend.repository;

import com.network.backend.model.Message;
import com.network.backend.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {
    Page<Message> findAllBySender(Users users, Pageable pageable);
}
