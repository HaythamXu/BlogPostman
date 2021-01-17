package com.haythamxu.blogpostman.services;

import java.util.Collection;

import com.haythamxu.blogpostman.dto.BlogDTO;

public interface BlogService {

    BlogDTO getBlogByCode(String code);

    void updateBlogAfterPull(String basePath);

    Collection<BlogDTO> getBlogList();
}
