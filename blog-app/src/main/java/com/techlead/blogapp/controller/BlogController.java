package com.techlead.blogapp.controller;


import com.techlead.blogapp.model.Blog;
import com.techlead.blogapp.service.implementation.BlogServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static com.techlead.blogapp.constants.Constants.*;

@RestController
@RequestMapping(BASE_URL)
@AllArgsConstructor
public class BlogController {

    private final BlogServiceImpl blogServiceImpl;


    @PostMapping(PUBLISH_BLOG)
    public ResponseEntity<Blog> publishBlogPost(@RequestBody Blog blog){
        return ResponseEntity.ok().body(blogServiceImpl.publishBlog(blog));
    }

    @PostMapping(UPDATE_BLOG)
    public ResponseEntity<Blog> updateBlogPost(@RequestBody Blog blog){
        return ResponseEntity.ok().body(blogServiceImpl.updateBlog(blog));
    }


    @GetMapping(SEARCH_BLOG)
    public ResponseEntity<Set<Blog>> searchBlogPost(@RequestBody SearchData data){


        return ResponseEntity.ok().body(blogServiceImpl.searchBlog(data));
    }

    @GetMapping(DELETE_BLOG)
    public String deleteBlogPost(@PathVariable("id") Long id){
         return blogServiceImpl.deleteBlog(id);
    }

    @PostMapping(UPDATE_BLOG_TAG)
    public ResponseEntity<Blog> updateBlogTagPost(@RequestBody Blog blog){
        return ResponseEntity.ok().body(blogServiceImpl.updateBlogTag(blog));
    }

    @GetMapping(VIEW_ALL_BLOGS)
    public ResponseEntity<List<Blog>> viewAllBlogPosts(){
        return ResponseEntity.ok().body(blogServiceImpl.viewAllBlogs());
    }


}

