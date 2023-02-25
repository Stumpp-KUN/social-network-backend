package com.network.backend.web.dto.subscription;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Subscription;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;

public class SubscriptionDTOForCreate extends SubscriptionDTO{
    @ConstructorProperties({"users","subscription"})
    public SubscriptionDTOForCreate(Users user_id, Users sub_id){
        setUser(user_id);
        setSub_id(sub_id);
    }

    public SubscriptionDTOForCreate(Subscription subscription) {
        setSub_id(subscription.getSubscriber());
        setUser(subscription.getUser());
    }

    @JsonIgnore
    public Subscription getEntity(){
        Subscription subscription=new Subscription();
        subscription.setUser(this.getUser());
        subscription.setSubscriber(this.getSub_id());
        return subscription;
    }
}
