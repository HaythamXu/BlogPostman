package com.haythamxu.blogpostman.controllers;

import java.util.Collection;

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

    @GetMapping("/blog/{code}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable("code") String code) {
        final BlogDTO ABlog = this.blogService.getBlogByCode(code);
        return new ResponseEntity<>(ABlog, HttpStatus.OK);
    }

    @GetMapping("/bloglist")
    public ResponseEntity<Collection<BlogDTO>> getBlogList() {
        final Collection<BlogDTO> blogDTOCollection = this.blogService.getBlogList();
        return new ResponseEntity<>(blogDTOCollection, HttpStatus.OK);
    }

}
