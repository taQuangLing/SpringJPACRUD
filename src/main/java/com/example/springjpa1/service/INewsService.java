package com.example.springjpa1.service;

import com.example.springjpa1.repository.NewsRepository;
import com.example.springjpa1.request.NewRequest;
import com.example.springjpa1.response.news.NewResponse;
import com.example.springjpa1.response.news.NewsResponse;

public interface INewsService{
    public NewsResponse searchByTitle(String title);
    public NewResponse save(NewRequest NewRequest);
    public NewsResponse getAll();
    public NewResponse getById(Integer id);
    public NewResponse update(NewRequest newRequest);
    public NewResponse delete(Integer id);
}
