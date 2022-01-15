package com.techlead.blogapp.service.implementation;

import com.techlead.blogapp.model.Blog;
import com.techlead.blogapp.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
public class ManageTags extends BlogServiceImpl{


    public ManageTags(BlogRepository blogRepository) {
        super(blogRepository);
    }

    @Override
    public Blog updateBlogTag(Blog blog) {

        blog.setTag(blog.getTag());

        return blogRepository.save(blog);

    }

}
