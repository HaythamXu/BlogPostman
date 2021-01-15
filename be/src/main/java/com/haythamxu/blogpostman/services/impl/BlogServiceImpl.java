package com.haythamxu.blogpostman.services.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.haythamxu.blogpostman.dto.BlogDTO;
import com.haythamxu.blogpostman.model.Blog;
import com.haythamxu.blogpostman.repositories.BlogRepository;
import com.haythamxu.blogpostman.services.BlogService;
import com.haythamxu.blogpostman.utils.Blogutil;

@Component
public class BlogServiceImpl implements BlogService {

    @Value("${blog.local.path}")
    private String blogPath;

    @Value("${blog.repo.name}")
    private String blogRepoName;

    @Value("${blog.repo.ignore}")
    private String [] fileIgnore;

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogDTO getBlogById(String id) {
        final Blog aBlog = this.blogRepository.findByTitle(id);
        String basePath = System.getProperty( "user.dir" );
        String targetPath = basePath + this.blogPath + this.blogRepoName + aBlog.getRelativePath();
        String blogContent = Blogutil.getBlogContent(targetPath, aBlog.getTitle());
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setTitle(aBlog.getTitle());
        blogDTO.setContent(blogContent);
        return blogDTO;
    }

    @Override
    public void updateBlogAfterPull(String basePath) {
        Collection<BlogDTO> blogDTOCollection = Blogutil.getFiles(basePath, this.fileIgnore, basePath);

        blogDTOCollection.forEach(blogDTO -> {
            Blog blog = this.blogRepository.findByTitle(blogDTO.getTitle());

            // null if relative path is the same is not enough to judge if they are the same.
            // I think Need to compare the commit id, then update depended.
            // so even though this logic can be simplified, but just keep it here.
            if(blog == null) {
                // map DTO to Model
                Blog newBlog = new Blog();
                newBlog.setTitle(blogDTO.getTitle());
                newBlog.setRelativePath(blogDTO.getRelativePath());
                this.blogRepository.save(newBlog);
            } else {
                if (!blog.getRelativePath().equals(blogDTO.getRelativePath())) {
                    // map DTO to Model
                    blog.setTitle(blogDTO.getTitle());
                    blog.setRelativePath(blogDTO.getRelativePath());
                    this.blogRepository.save(blog);
                } else {
                    // I think the blog is the same, do nothing.
                }
            }
        });

        Blogutil.blogDTOCollection.clear();
    }

}
