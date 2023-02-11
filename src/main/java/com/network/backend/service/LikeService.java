package com.network.backend.service;

import com.network.backend.exception.NoSuchLike;
import com.network.backend.model.Like;
import com.network.backend.repository.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Transactional
    public Like saveLike(Like like){
        return likeRepository.save(like);
    }
    @Transactional
    public Like getLike(long id){
        Optional<Like> like=likeRepository.findById(id);
        if(like.isEmpty()) return null;
        return like.get();
    }
    @Transactional
    public Like updateLike(Like like){
        return likeRepository.save(like);
    }
    @Transactional
    public void deleteLike(long id){
        likeRepository.deleteById(id);
    }

    @Transactional
    public int getLikes(long id){
        return likeRepository.findAllByPost_id(id);
    }
}
