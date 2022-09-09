package com.example.springjpa1.service.implement;


import com.example.springjpa1.converter.NewsConverter;
import com.example.springjpa1.entity.NewEntity;
import com.example.springjpa1.repository.NewsRepository;
import com.example.springjpa1.request.NewRequest;
import com.example.springjpa1.response.news.NewResponse;
import com.example.springjpa1.response.news.NewsResponse;
import com.example.springjpa1.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService implements INewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsConverter newsConverter;

    @Override
    public NewsResponse searchByTitle(String title) {
        List<NewEntity> newsEntities = newsRepository.findByTitle(title);
        NewsResponse newsResponse = new NewsResponse();
        for (NewEntity newEntity: newsEntities){
            newsResponse.getNews().add(newsConverter.toResponse(newEntity));
        }
        return newsResponse;
    }

    @Override
    public NewResponse save(NewRequest NewRequest){
        NewEntity newEntity = newsConverter.toEntity(NewRequest);
        newsRepository.save(newEntity);
        NewResponse rsp = newsConverter.toResponse(newEntity);
        return rsp;
    }

    @Override
    public NewsResponse getAll() {
        List<NewEntity> newsEntities = newsRepository.findAll();
        NewsResponse newsResponse = new NewsResponse();
        for (NewEntity newEntity: newsEntities){
            newsResponse.getNews().add(newsConverter.toResponse(newEntity));
        }
        return newsResponse;
    }

    @Override
    public NewResponse getById(Integer id) {
        Optional<NewEntity> newEntity = newsRepository.findById(id);
        return newsConverter.toResponse(newEntity.get());
    }

    @Override
    public NewResponse update(NewRequest newRequest) {
        Optional<NewEntity> newEntity = newsRepository.findById(newRequest.getId());
        NewResponse newResponse = newsConverter.toResponse(newEntity.get());
        NewEntity newEntityUpdated = newsConverter.toEntity(newRequest);
        newsRepository.save(newEntityUpdated);
        return newResponse;
    }

    @Override
    public NewResponse delete(Integer id) {
        NewEntity newEntity = newsRepository.findById(id).get();
        newsRepository.delete(newEntity);
        return newsConverter.toResponse(newEntity);
    }


}
