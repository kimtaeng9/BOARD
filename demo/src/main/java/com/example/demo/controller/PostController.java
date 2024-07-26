package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService; // postService 주입 받는다.

    // 모든 게시글을 가져오는 엔드포인트
    @GetMapping
    public List<Post> getAllPosts() {
        // PostService의 getAllPosts 메서드를 호출하여 모든 게시글을 가져옵니다.
        return postService.getAllPosts();
    }

    // ID로 특정 게시글을 가져오는 엔드포인트
    @GetMapping("/{id}") // HTTP GET요청을 처리하는 메서드 정의.
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postService.getPostById(id);
        if(post == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post); // 200 OK 응답과 함께 게시글 반환
    }

    // 새로운 게시글을 생성하는 엔드포인트
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // 기존 게시글을 수정하는 엔드포인트
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postDetails){
        Post updatePost = postService.updatePost(id,postDetails);
        if(updatePost == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatePost);
    }

    // 특정 게시글을 삭제하는 엔드포인트
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        if(postService.deletePost(id)){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
