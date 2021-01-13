package com.haythamxu.blogpostman.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubWebhookController {

    @GetMapping("/githubwebhook")
    public ResponseEntity<Void> getApplicationConfigurationDetails() {

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
