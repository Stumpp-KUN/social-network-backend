package com.network.backend.dto.subscription;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Subscription;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;

public class SubscriptionDTOForReadOrUpdate extends SubscriptionDTO{
    @ConstructorProperties({"id","user_id","sub_id"})
    public SubscriptionDTOForReadOrUpdate(long id,Users user_id, Users sub_id){
        setId(id);
        setUser(user_id);
        setSub_id(sub_id);
    }

    public SubscriptionDTOForReadOrUpdate(Subscription subscription) {
        setId(subscription.getId());
        setSub_id(subscription.getSubscriber());
        setUser(subscription.getUser());
    }

    @JsonIgnore
    public Subscription getEntity(){
        Subscription subscription=new Subscription();
        subscription.setId(this.getId());
        subscription.setUser(this.getUser());
        subscription.setSubscriber(this.getSub_id());
        return subscription;
    }
}
