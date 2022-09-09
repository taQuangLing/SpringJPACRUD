package com.example.springjpa1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "category")
public class CategoryEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
