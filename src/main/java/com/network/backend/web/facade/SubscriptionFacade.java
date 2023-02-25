package com.network.backend.web.facade;

import com.network.backend.exception.EntityNotFoundException;
import com.network.backend.web.dto.subscription.SubscriptionDTOForCreate;
import com.network.backend.web.dto.subscription.SubscriptionDTOForReadOrUpdate;
import com.network.backend.model.Subscription;
import com.network.backend.service.SubscriptionService;
import com.network.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionFacade {
    private final SubscriptionService subscriptionService;
    private final UserService userService;
    private final UserFacade userFacade;

    public SubscriptionDTOForCreate createSub(SubscriptionDTOForCreate sub){
        Subscription subscription=subscriptionService.createSub(getEntityByCreateSub(sub));
        return getCreateDTOByEntity(subscription);
    }

    private Subscription getEntityByCreateSub(SubscriptionDTOForCreate sub){
        Subscription subscription=sub.getEntity();
        return subscription;
    }

    private SubscriptionDTOForCreate getCreateDTOByEntity(Subscription subscription){
        SubscriptionDTOForCreate subscriptionDTOForCreate=new SubscriptionDTOForCreate(subscription);
        return subscriptionDTOForCreate;
    }


    public SubscriptionDTOForReadOrUpdate getSub(long id){
        Subscription subscription=subscriptionService.getSub(id);
        return getRUDTOByEntity(subscription);
    }

    private Subscription getEntityByRUDTO(SubscriptionDTOForReadOrUpdate sub) {
        Subscription subscription=sub.getEntity();
        return subscription;
    }

    private SubscriptionDTOForReadOrUpdate getRUDTOByEntity(Subscription subscription){
        SubscriptionDTOForReadOrUpdate subscriptionDTOForReadOrUpdate=new SubscriptionDTOForReadOrUpdate(subscription);
        return subscriptionDTOForReadOrUpdate;
    }

    public SubscriptionDTOForReadOrUpdate updSub(SubscriptionDTOForReadOrUpdate sub){
        Subscription subscription=subscriptionService.updSub(getEntityByRUDTO(sub));
        return getRUDTOByEntity(subscription);
    }

    public void deleteSub(long id){
        if (subscriptionService.getSub(id)==null) throw new EntityNotFoundException("There is not sub with id "+id);
        subscriptionService.deleteSub(id);
    }

    public int getCountOfSub(long id){
        return subscriptionService.getUs(id);
    }

    public int getCountOfFollow(long id){
        return subscriptionService.getFollow(id);
    }

    public Page<Subscription> getSubById(long id,Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return subscriptionService.getFollows(id,paging);
    }

    public Page<Subscription> getFollowsById(long id,Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
       return subscriptionService.getFollowing(id,paging);
    }
}
