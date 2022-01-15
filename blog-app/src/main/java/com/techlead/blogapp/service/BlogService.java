package com.techlead.blogapp.service;

import com.techlead.blogapp.controller.SearchData;
import com.techlead.blogapp.model.Blog;


import java.util.List;
import java.util.Set;

public interface BlogService {
    Blog publishBlog(Blog blog);
    Blog updateBlog(Blog blog);
    Set<Blog> searchBlog(SearchData type);
    String deleteBlog(Long id);
    Blog updateBlogTag(Blog blog);
    List<Blog> viewAllBlogs();


}
