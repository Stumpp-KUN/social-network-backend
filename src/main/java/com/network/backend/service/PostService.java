package com.network.backend.service;

import com.network.backend.model.exception.NoSuchPost;
import com.network.backend.model.Post;
import com.network.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public Post getPost(long id){
        return postRepository.findById(id).orElseThrow(()->new NoSuchPost("There is not post with id "+id));
    }

    @Transactional
    public Post updatePost(Post post){
        return postRepository.save(post);
    }

    @Transactional
    public void deletePost(long id){
        postRepository.deleteById(id);
    }

    public Page<Post> getPostsById(long id,Pageable paging){
        return postRepository.findAllByUsers_Id(id,paging);
    }



}
