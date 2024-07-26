package com.example.demo.service;


import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>(); // List<Post> 타입의 필드로, 모든 게시글 저장
    private final AtomicLong counter = new AtomicLong(); // 고유한 ID 생성하는데 사용할 것

    public List<Post> getAllPosts(){ // 모든 게시글을 반환
        return new ArrayList<>(posts);
    }

    public Post getPostById(Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        return null;
    }

    public Post createPost(Post post){
        post.setId(counter.incrementAndGet()); // 이전 값을 1만큼 증가시키고 int 데이터 유형의 업데이트 후 값 반환
        posts.add(post);
        return post;
    }

    public Post updatePost(Long id, Post postDetails){
        Post post = getPostById(id);
        if(post != null){
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            return post;
        }
        return null;
    }

    public boolean deletePost(Long id){
        Iterator<Post> iterator = posts.iterator();
        while(iterator.hasNext()){
            Post post = iterator.next();
            if(post.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
