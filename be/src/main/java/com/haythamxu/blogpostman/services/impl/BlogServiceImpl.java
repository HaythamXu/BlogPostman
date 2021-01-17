package com.haythamxu.blogpostman.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.haythamxu.blogpostman.dto.BlogDTO;
import com.haythamxu.blogpostman.model.Blog;
import com.haythamxu.blogpostman.repositories.BlogRepository;
import com.haythamxu.blogpostman.services.BlogService;
import com.haythamxu.blogpostman.utils.Blogutil;
import com.haythamxu.blogpostman.utils.CodeGeneratorUtil;

@Component
public class BlogServiceImpl implements BlogService {

    @Value("${blog.local.path}")
    private String blogPath;

    @Value("${blog.repo.name}")
    private String blogRepoName;

    @Value("${blog.repo.ignore}")
    private String [] fileIgnore;

    @Value("${blog.code.length}")
    private int blogCodeLength;

    @Value("${blog.default.author}")
    private String blogDefaultAuthor;

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogDTO getBlogByCode(String code) {
        final Blog aBlog = this.blogRepository.findByCode(code);
        BlogDTO blogDTO = new BlogDTO();
        this.mapModelToDTO(aBlog, blogDTO);
        return blogDTO;
    }

    @Override
    public Collection<BlogDTO> getBlogList() {
        Collection<Blog> blogCollection = this.blogRepository.findAll();
        Collection<BlogDTO> blogDTOCollection = new ArrayList<>();
//        BlogDTO aBlogDTO;
        blogCollection.forEach(blog -> {
            BlogDTO blogDTO = new BlogDTO();
            this.mapModelToDTO(blog, blogDTO);
            blogDTOCollection.add(blogDTO);
        });
        return blogDTOCollection;
    }

    private void mapModelToDTO(Blog blog, BlogDTO blogDTO) {
        blogDTO.setCode(blog.getCode());
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setCreated(blog.getCreated());
        blogDTO.setLastModified(blog.getLastModified());
        blogDTO.setAuthor(blog.getAuthor());

        String basePath = System.getProperty( "user.dir" );
        String targetPath = basePath + this.blogPath + this.blogRepoName + blog.getRelativePath();
        String blogContent = Blogutil.getBlogContent(targetPath, blog.getTitle());
        blogDTO.setContent(blogContent);
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
                // set code
                String code = null;
                while(Boolean.TRUE) {
                    code = CodeGeneratorUtil.randomAlphanumeric(this.blogCodeLength);
                    if(this.blogRepository.findByCode(code) == null) {
                        break;
                    }
                }
                newBlog.setAuthor(this.blogDefaultAuthor);
                newBlog.setCode(code);
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
