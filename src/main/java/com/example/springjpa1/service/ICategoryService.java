package com.example.springjpa1.service;

import com.example.springjpa1.entity.CategoryEntity;

public interface ICategoryService {
    public CategoryEntity findByCode(String code);
}
