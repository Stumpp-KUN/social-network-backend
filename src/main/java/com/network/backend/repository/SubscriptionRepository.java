package com.network.backend.repository;

import com.network.backend.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {
    int countAllByUser_Id(long id);
    int countAllBySubscriber_Id(long id);
    Page<Subscription> findAllByUser_id(long id,Pageable pageable);
    Page<Subscription> findAllBySubscriber_Id(long id,Pageable pageable);

}
