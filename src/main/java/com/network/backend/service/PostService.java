package com.network.backend.service;

import com.network.backend.exception.EntityNotFoundException;
import com.network.backend.model.Image;
import com.network.backend.model.Post;
import com.network.backend.repository.ImageRepository;
import com.network.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ImageRepository imageRepository;

    private String PATH="D:\\p\\";

    @Transactional(rollbackFor = Exception.class)
    public Post savePost(Post post){
        imageRepository.save(new Image(post.getId(),PATH+post.getBase64image()+".jpg"));
        try {
            createFile(post.getBase64image());
        } catch (IOException e) {
            throw new EntityNotFoundException("error");
        }
        return postRepository.save(post);
    }

    private void createFile(String base64) throws IOException {
        File directory=new File(PATH+base64);
        File file=new File(PATH+base64+directory.getAbsolutePath()+".jpg");
//        if(file.length()<3000000)
//            throw new NoSuchFileException("length should be more than 3Mb");
        if(directory.mkdirs()){
            file.createNewFile();
            FileWriter writer=new FileWriter(file);
            writer.write(base64);
        }
    }

    public Post getPost(long id){
        return postRepository.findById(id).orElseThrow(()->new EntityNotFoundException("There is not post with id "+id));
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
