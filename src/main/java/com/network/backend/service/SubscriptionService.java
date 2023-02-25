package com.network.backend.service;

import com.network.backend.web.dto.subscription.SubscriptionDTOForReadOrUpdate;
import com.network.backend.model.exception.NoSuchSub;
import com.network.backend.model.Subscription;
import com.network.backend.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Transactional
    public Subscription createSub(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }

    public Subscription getSub(long id){
        return subscriptionRepository.findById(id).orElseThrow(()->new NoSuchSub("There is not sub with id "+id));
    }

    @Transactional
    public Subscription updSub(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }

    @Transactional
    public void deleteSub(long id){
        subscriptionRepository.deleteById(id);
    }

    public int getUs(long id){
        return subscriptionRepository.countAllByUser_Id(id);
    }

    public int getFollow(long id){
        return subscriptionRepository.countAllBySubscriber_Id(id);
    }

    public Page<Subscription> getFollows(long id,Pageable paging){
        Page<Subscription> pagedResult=subscriptionRepository.findAllByUser_id(id,paging);
        if(pagedResult.hasContent()) {
            return pagedResult;
        } else {
            return null;
        }
    }

    public Page<Subscription> getFollowing(long id,Pageable paging){
        Page<Subscription> pagedResult=subscriptionRepository.findAllBySubscriber_Id(id,paging);
        if(pagedResult.hasContent()) {
            return pagedResult;
        } else {
            return null;
        }
    }

}
