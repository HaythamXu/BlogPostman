package com.haythamxu.blogpostman.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.haythamxu.blogpostman.dto.BlogDTO;
import com.haythamxu.blogpostman.services.BlogService;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable("id") String id) {
        final BlogDTO ABlog = this.blogService.getBlogById(id);
        return new ResponseEntity<>(ABlog, HttpStatus.OK);
    }

}
