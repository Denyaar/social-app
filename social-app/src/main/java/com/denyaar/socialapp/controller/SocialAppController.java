/**
 * Created by tendaimupezeni for social-app
 * Date: 5/13/24
 * Time: 11:12 AM
 */

package com.denyaar.socialapp.controller;

import com.denyaar.socialapp.model.Comment;
import com.denyaar.socialapp.model.Post;
import com.denyaar.socialapp.repository.CommentRepository;
import com.denyaar.socialapp.repository.PostRepository;
import org.hibernate.FetchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/social-app/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class SocialAppController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/posts")
    public Iterable<Post> getAllPosts()
    {
        return postRepository.findAll();
    }

    @PostMapping("/add-posts")
    public Post addPost(@RequestBody Post post)
    {
        return postRepository.save(post);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        var thePost =  postRepository.findById(id).orElseThrow(() -> new FetchNotFoundException("Post", id));
        return ResponseEntity.ok(thePost);
    }


    @PutMapping("/likes/{id}/{like}")
    public ResponseEntity<Post> updateLikes(@PathVariable Long id, @PathVariable int like) {

        var post = postRepository.findById(id).orElseThrow(() -> new FetchNotFoundException("Post", id));
        post.setLike(like + 1);

        Post updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);

    }

    @PutMapping("/unlikes/{id}/{unlike}")
    public ResponseEntity<Post> updateUnlike(@PathVariable Long id, @PathVariable int unlike){

        var post = postRepository.findById(id).orElseThrow(()->new FetchNotFoundException("Post",id));
        post.setUnlike(unlike +1);

        Post updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);

    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<Post> updateComment(@PathVariable Long id, @RequestBody Comment comment){
        var post = postRepository.findById(id).orElseThrow(()->new FetchNotFoundException("Post",id));
        post.getComments().add(comment);

        var updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);

    }




}
