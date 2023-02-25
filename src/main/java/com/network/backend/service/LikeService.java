package com.network.backend.service;

import com.network.backend.exception.EntityNotFoundException;
import com.network.backend.model.Like;
import com.network.backend.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    @Transactional
    public Like saveLike(Like like){
        return likeRepository.save(like);
    }

    public Like getLike(long id){
        Optional<Like> optionalLike=likeRepository.findById(id);
        System.out.println(id);
        Like like=optionalLike.get();
        System.out.println(like.toString());
        return likeRepository.findById(id).orElseThrow(()->new EntityNotFoundException("There is not like with id "+id));
    }

    @Transactional
    public Like updateLike(Like like){
        return likeRepository.save(like);
    }
    @Transactional
    public void deleteLike(long id){
        likeRepository.deleteById(id);
    }

    public int getLikes(long id){
        return likeRepository.countLikesByPost_Id(id);
    }
}
