package com.haythamxu.blogpostman.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.haythamxu.blogpostman.services.BlogService;
import com.haythamxu.blogpostman.services.GithubService;
import com.haythamxu.blogpostman.utils.GitUtil;

@Component
public class GithubServiceImpl implements GithubService {

    @Value("${blog.local.path}")
    private String blogPath;

    @Value("${blog.repo.name}")
    private String blogRepoName;

    @Autowired
    private BlogService blogService;

    @Override
    public void pullFromGithub() {
        String basePath = System.getProperty( "user.dir" );
        String targetPath = basePath + this.blogPath + this.blogRepoName;
        GitUtil.pull(targetPath);
        this.blogService.updateBlogAfterPull(targetPath);
    }
}
