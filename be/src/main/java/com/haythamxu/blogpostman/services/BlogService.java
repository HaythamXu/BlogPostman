package com.haythamxu.blogpostman.services;

import com.haythamxu.blogpostman.dto.BlogDTO;

public interface BlogService {

    BlogDTO getBlogById(String id);

    void updateBlogAfterPull(String basePath);

}
