package com.haythamxu.blogpostman.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Table(name = "blog")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Blog {

    public Blog() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(nullable = false, updatable = false)
    private String code;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @LastModifiedDate
    private Date lastModified;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name="relativePath")
    private String relativePath;

}
