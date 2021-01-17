package com.haythamxu.blogpostman.dto;


import java.util.Date;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class BlogDTO {

    private String code;
    private String title;
    private String content;
    private String author;
    private String relativePath;
    private Date created;
    private Date lastModified;
}
