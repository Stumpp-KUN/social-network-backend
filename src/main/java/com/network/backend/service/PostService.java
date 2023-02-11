package com.network.backend.service;

import com.network.backend.exception.NoSuchPost;
import com.network.backend.model.Post;
import com.network.backend.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Post savePost(Post post){
        return postRepository.save(post);
    }

    @Transactional
    public Post getPost(long id){
        Optional<Post> post=postRepository.findById(id);
        if(post.isEmpty()) return null;
        return post.get();
    }

    @Transactional
    public Post updatePost(Post post){
        return postRepository.save(post);
    }

    @Transactional
    public void deletePost(long id){
        postRepository.deleteById(id);
    }



}
