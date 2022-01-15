package com.techlead.blogapp.repository;

import com.techlead.blogapp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    Blog findByTitle(String title);
    Blog findByType(String type);
}
