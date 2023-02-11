package com.network.backend.controller;

import com.network.backend.dto.post.PostDTOForCreateOrRead;
import com.network.backend.dto.post.PostDTOForReadWithLike;
import com.network.backend.dto.post.PostDTOForUpdate;
import com.network.backend.dto.subscription.SubscriptionDTOForCreate;
import com.network.backend.dto.subscription.SubscriptionDTOForReadOrUpdate;
import com.network.backend.dto.user.UserDTOForRead;
import com.network.backend.facade.SubscriptionFasade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subscriptions")
public class SubscriptionController {
    private SubscriptionFasade subscriptionFasade;

    public SubscriptionController(SubscriptionFasade subscriptionFasade) {
        this.subscriptionFasade = subscriptionFasade;
    }

    @PostMapping("/")
    public ResponseEntity<SubscriptionDTOForCreate> createSubscription(@Valid @RequestBody SubscriptionDTOForCreate post){
        return new ResponseEntity<>(subscriptionFasade.createSub(post), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDTOForReadOrUpdate> getSubscription(@PathVariable long id){
        return new ResponseEntity<>(subscriptionFasade.getSub(id),HttpStatus.OK);
    }

    @GetMapping("/sub/{id}")
    public ResponseEntity<Integer> getSubCount(@PathVariable long id){
        return new ResponseEntity<>(subscriptionFasade.getCountOfSub(id),HttpStatus.OK);
    }

    @GetMapping("/follow/{id}")
    public ResponseEntity<Integer> getFollowCount(@PathVariable long id){
        return new ResponseEntity<>(subscriptionFasade.getCountOfFollow(id),HttpStatus.OK);
    }

    @GetMapping("/allSubs/{id}")
    public ResponseEntity<List<UserDTOForRead>> getSubsById(@PathVariable long id,
                                                            @RequestParam(defaultValue = "0") Integer pageNo,
                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @RequestParam(defaultValue = "id") String sortBy){
        return new ResponseEntity<>(subscriptionFasade.getSubById(id,pageNo,pageSize,sortBy),HttpStatus.OK);
    }

    @GetMapping("/allFollows/{id}")
    public ResponseEntity<List<UserDTOForRead>> getFollowsById(@PathVariable long id,
                                                               @RequestParam(defaultValue = "0") Integer pageNo,
                                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                                               @RequestParam(defaultValue = "id") String sortBy){
        return new ResponseEntity<>(subscriptionFasade.getFollowsById(id,pageNo,pageSize,sortBy),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<SubscriptionDTOForReadOrUpdate> updateSubscription(@Valid @RequestBody SubscriptionDTOForReadOrUpdate post){
        return new ResponseEntity<>(subscriptionFasade.updSub(post),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable long id){
        subscriptionFasade.deleteSub(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
