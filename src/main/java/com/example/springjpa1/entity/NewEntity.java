package com.example.springjpa1.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "news")
public class NewEntity extends BaseEntity{
    @Column(name = "title")
    private String title;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "content")
    private String content;

    @Column(name = "category_id")
    private Integer categoryId;
}
