package com.haythamxu.blogpostman.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.haythamxu.blogpostman.model.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    Blog findByTitle(String title);

}
