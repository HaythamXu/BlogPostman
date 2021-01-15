package com.haythamxu.blogpostman.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.haythamxu.blogpostman.dto.BlogDTO;
import com.haythamxu.blogpostman.model.Blog;
import com.haythamxu.blogpostman.repositories.BlogRepository;
import com.haythamxu.blogpostman.services.BlogService;
import com.haythamxu.blogpostman.utils.Blogutil;

@Component
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogDTO getBlogById(String id) {
        final Blog aBlog = this.blogRepository.getBlogById(Long.getLong(id));
        String blogContent = Blogutil.getBlogContent(aBlog.getRelativePath(), aBlog.getTitle());
        System.out.println(blogContent);
        return null;
    }

    @Override
    public void updateBlogAfterPull() {

    }

}
