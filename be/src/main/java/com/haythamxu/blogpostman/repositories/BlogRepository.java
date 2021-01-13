package com.haythamxu.blogpostman.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.haythamxu.blogpostman.model.Blog;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    Blog getBlogById(Long id);

}
