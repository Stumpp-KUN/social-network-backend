package com.network.backend.facade;

import com.network.backend.dto.subscription.SubscriptionDTOForCreate;
import com.network.backend.dto.subscription.SubscriptionDTOForReadOrUpdate;
import com.network.backend.dto.user.UserDTOForRead;
import com.network.backend.exception.NoSuchSub;
import com.network.backend.model.Subscription;
import com.network.backend.service.SubscriptionService;
import com.network.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubscriptionFasade {
    private SubscriptionService subscriptionService;
    private UserService userService;
    private UserFasade userFasade;

    public SubscriptionFasade(SubscriptionService subscriptionService, UserService userService, UserFasade userFasade) {
        this.subscriptionService = subscriptionService;
        this.userService = userService;
        this.userFasade = userFasade;
    }

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
        if (subscription==null) throw new NoSuchSub("There is not sub with id "+id);
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
        if (subscriptionService.getSub(id)==null) throw new NoSuchSub("There is not sub with id "+id);
        subscriptionService.deleteSub(id);
    }

    public int getCountOfSub(long id){
        return subscriptionService.getUs(id);
    }

    public int getCountOfFollow(long id){
        return subscriptionService.getFollow(id);
    }

    public List<UserDTOForRead> getSubById(long id,Integer pageNo, Integer pageSize, String sortBy){
        List<Subscription> subscriptions=subscriptionService.getFollows(id,pageNo,pageSize,sortBy);
        List<UserDTOForRead> userDTOForReads=new ArrayList<>();
        subscriptions.stream().forEach(subscription -> userDTOForReads.add(userFasade.readUserDTO(subscription.getSubscriber())));
        return userDTOForReads;
    }

    public List<UserDTOForRead> getFollowsById(long id,Integer pageNo, Integer pageSize, String sortBy){
        List<Subscription> subscriptions=subscriptionService.getFollowing(id,pageNo,pageSize,sortBy);
        List<UserDTOForRead> userDTOForReads=new ArrayList<>();
        subscriptions.stream().forEach(subscription -> userDTOForReads.add(userFasade.readUserDTO(subscription.getUser())));
        return userDTOForReads;
    }
}
