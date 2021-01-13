package com.haythamxu.blogpostman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haythamxu.blogpostman.services.GithubService;

@RestController
public class GithubWebhookController {

    @Autowired
    private GithubService githubService;

    @GetMapping("/githubwebhook")
    public ResponseEntity<Void> getApplicationConfigurationDetails() {
        this.githubService.pullFromGithub();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
