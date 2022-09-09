package com.example.springjpa1.service.implement;

import com.example.springjpa1.entity.CategoryEntity;
import com.example.springjpa1.repository.CategoryRepository;
import com.example.springjpa1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity findByCode(String code) {
        List<CategoryEntity> categories = categoryRepository.findByCode(code);
        for (CategoryEntity category : categories){
            System.out.println(category);
        }
        return !categories.isEmpty() ? categories.get(0) : null;
    }
}
