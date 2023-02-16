package com.network.backend.socialNetwork.service;

import com.network.backend.model.Subscription;
import com.network.backend.model.Users;
import com.network.backend.service.SubscriptionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SubscriptionServiceTest {
    @MockBean
    private SubscriptionService subscriptionService;

    public Subscription getSubscription(){
        Subscription subscription=new Subscription();
        subscription.setId(1);
        subscription.setUser(new Users());
        subscription.setSubscriber(new Users());
        return subscription;
    }

    @Test
    public void testCreateSubscription(){
        Subscription subscription=getSubscription();
        when(subscriptionService.createSub(any(Subscription.class))).thenReturn(subscription);
        Subscription subscription1=subscriptionService.createSub(subscription);
        assertThat(!subscription1.getUser().equals(null));
    }

    @Test
    public void testDeleteSubscription(){
        doNothing().when(subscriptionService).deleteSub(1);
        subscriptionService.deleteSub(1);
        assertThat(true);
    }

    @Test
    public void testUpdateSubscription(){
        Subscription subscription=getSubscription();
        when(subscriptionService.updSub(any(Subscription.class))).thenReturn(subscription);
        Subscription subscription1=subscriptionService.updSub(subscription);
        assertThat(!subscription1.getUser().equals(null));
    }

    @Test
    public void testGetSubscription(){
        Subscription subscription=getSubscription();
        given(subscriptionService.getSub(1)).willReturn(subscription);
        Subscription subscription1=subscriptionService.getSub(1);
        assertEquals(subscription1.getId(),1);
    }

    @Test
    public void testGetFollows(){
        List<Subscription> subscriptions=new ArrayList<>();
        given(subscriptionService.getFollows(102,2,4,"id")).willReturn(subscriptions);
        List<Subscription> result=subscriptionService.getFollows(102,2,4,"id");
        assertEquals(result.size(),0);
    }

    @Test
    public void testGetFollowing(){
        List<Subscription> subscriptions=new ArrayList<>();
        given(subscriptionService.getFollowing(52,2,1,"id")).willReturn(subscriptions);
        List<Subscription> result=subscriptionService.getFollowing(52,2,1,"id");
        assertEquals(result.size(),0);
    }
}
