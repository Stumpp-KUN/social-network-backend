package com.network.backend.repository;

import com.network.backend.model.Message;
import com.network.backend.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Long> {
    Page<Message> findAllBySender(Users users, Pageable pageable);
}
