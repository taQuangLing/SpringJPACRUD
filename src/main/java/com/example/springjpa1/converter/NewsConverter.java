package com.example.springjpa1.converter;

import com.example.springjpa1.entity.CategoryEntity;
import com.example.springjpa1.entity.NewEntity;
import com.example.springjpa1.request.NewRequest;
import com.example.springjpa1.response.news.NewResponse;
import com.example.springjpa1.service.implement.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsConverter {
    @Autowired
    private CategoryService categoryService;
    public NewEntity toEntity(NewRequest newRequest){
        NewEntity newEntity = new NewEntity();
        CategoryEntity categoryEntity = categoryService.findByCode(newRequest.getCategoryCode());

        newEntity.setId(newRequest.getId());
        newEntity.setTitle(newRequest.getTitle());
        newEntity.setThumbnail(newRequest.getThumbnail());
        newEntity.setContent(newRequest.getContent());
        newEntity.setShortDescription(newRequest.getShortDescription());
        newEntity.setCategoryId(categoryEntity.getId());
        return newEntity;
    }

    public NewResponse toResponse(NewEntity newEntity) {
        NewResponse newResponse = new NewResponse();

        newResponse.setCategoryId(newEntity.getCategoryId());
        newResponse.setContent(newEntity.getContent());
        newResponse.setTitle(newEntity.getTitle());
        newResponse.setId(newEntity.getId());
        newResponse.setThumbnail(newEntity.getThumbnail());
        newResponse.setShortDescription(newEntity.getShortDescription());
        return newResponse;
    }
}
