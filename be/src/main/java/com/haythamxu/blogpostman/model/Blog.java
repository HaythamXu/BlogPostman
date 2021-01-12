package com.haythamxu.blogpostman.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Table(name = "blog")
@Entity
public class Blog {

    public Blog() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
//
//    @CreatedDate
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date created;
//
//    @LastModifiedDate
//    private Date lastModified;


}
