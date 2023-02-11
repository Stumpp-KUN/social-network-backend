package com.network.backend.service;

import com.network.backend.dto.user.UserDTOForRead;
import com.network.backend.model.Subscription;
import com.network.backend.repository.SubscriptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Transactional
    public Subscription createSub(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }

    @Transactional
    public Subscription getSub(long id){
        Optional<Subscription> subscription=subscriptionRepository.findById(id);
        if(subscription.isEmpty()) return null;
        return subscription.get();
    }

    @Transactional
    public Subscription updSub(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }

    @Transactional
    public void deleteSub(long id){
        subscriptionRepository.deleteById(id);
    }

    @Transactional
    public int getUs(long id){
        return subscriptionRepository.countAllByUser_Id(id);
    }

    @Transactional
    public int getFollow(long id){
        return subscriptionRepository.countAllBySubscriber_Id(id);
    }

    @Transactional
    public List<Subscription> getFollows(long id,Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Subscription> pagedResult=subscriptionRepository.findAllByUser_id(id,paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Subscription>();
        }
    }

    @Transactional
    public List<Subscription> getFollowing(long id,Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Subscription> pagedResult=subscriptionRepository.findAllBySubscriber_Id(id,paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Subscription>();
        }
    }

}
