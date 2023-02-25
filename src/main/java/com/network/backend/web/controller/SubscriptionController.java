package com.network.backend.web.controller;

import com.network.backend.model.Subscription;
import com.network.backend.web.dto.subscription.SubscriptionDTOForCreate;
import com.network.backend.web.dto.subscription.SubscriptionDTOForReadOrUpdate;
import com.network.backend.web.facade.SubscriptionFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionFacade subscriptionFacade;

    @PostMapping("/")
    public ResponseEntity<SubscriptionDTOForCreate> createSubscription(@Valid @RequestBody SubscriptionDTOForCreate post){
        return new ResponseEntity<>(subscriptionFacade.createSub(post), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDTOForReadOrUpdate> getSubscription(@PathVariable long id){
        return new ResponseEntity<>(subscriptionFacade.getSub(id),HttpStatus.OK);
    }

    @GetMapping("/sub/{id}")
    public ResponseEntity<Integer> getSubCount(@PathVariable long id){
        return new ResponseEntity<>(subscriptionFacade.getCountOfSub(id),HttpStatus.OK);
    }

    @GetMapping("/follow/{id}")
    public ResponseEntity<Integer> getFollowCount(@PathVariable long id){
        return new ResponseEntity<>(subscriptionFacade.getCountOfFollow(id),HttpStatus.OK);
    }

    @GetMapping("/allSubs/{id}")
    public ResponseEntity<Page<Subscription>> getSubsById(@PathVariable long id,
                                                            @RequestParam(defaultValue = "0") Integer pageNo,
                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @RequestParam(defaultValue = "id") String sortBy){
        return new ResponseEntity<>(subscriptionFacade.getSubById(id,pageNo,pageSize,sortBy),HttpStatus.OK);
    }

    @GetMapping("/allFollows/{id}")
    public ResponseEntity<Page<Subscription>> getFollowsById(@PathVariable long id,
                                                             @RequestParam(defaultValue = "0") Integer pageNo,
                                                             @RequestParam(defaultValue = "10") Integer pageSize,
                                                             @RequestParam(defaultValue = "id") String sortBy){
        return new ResponseEntity<>(subscriptionFacade.getFollowsById(id,pageNo,pageSize,sortBy),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<SubscriptionDTOForReadOrUpdate> updateSubscription(@Valid @RequestBody SubscriptionDTOForReadOrUpdate post){
        return new ResponseEntity<>(subscriptionFacade.updSub(post),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable long id){
        subscriptionFacade.deleteSub(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
