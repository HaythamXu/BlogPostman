package com.haythamxu.blogpostman.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.haythamxu.blogpostman.dto.BlogDTO;
import com.haythamxu.blogpostman.model.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {

    @Override
    Collection<Blog> findAll();

    Blog findByTitle(String title);
    Blog findByCode(String code);

}
