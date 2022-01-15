package com.techlead.blogapp.service.implementation;

import com.techlead.blogapp.controller.SearchData;
import com.techlead.blogapp.model.Blog;
import com.techlead.blogapp.repository.BlogRepository;
import com.techlead.blogapp.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public abstract class BlogServiceImpl implements BlogService {

    public final BlogRepository blogRepository;

    @Override
    public Blog publishBlog(Blog blog) {
         return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Blog blog) {

        blog.setTag(blog.getTitle());
        blog.setTag(blog.getTag());
        blog.setTag(blog.getPictureURl());
        blog.setTag(blog.getDescription());
        blog.setTag(blog.getRecommend());
        blog.setTag(blog.getType());

       return blogRepository.save(blog);
    }

    @Override
    public Set<Blog> searchBlog(SearchData searchData) {

        // search by keyword and type
        Set<Blog> allBlogs = new HashSet<Blog>();

        Blog keywordMatches = blogRepository.findByTitle(searchData.getKeyword());
        Blog typeMatches = blogRepository.findByType(searchData.getType());

        if (keywordMatches != null){

            allBlogs.add(keywordMatches);

        }else if (typeMatches != null){
            allBlogs.add(typeMatches);
        }

        return allBlogs;
    }

    @Override
    public String deleteBlog(Long id) {


        blogRepository.deleteById(id);

        return "blog Deleted";


    }

    @Override
    public List<Blog> viewAllBlogs() {

        return blogRepository.findAll();
    }




}
