package com.example.springjpa1.controller;

import com.example.springjpa1.request.NewRequest;
import com.example.springjpa1.response.news.NewResponse;
import com.example.springjpa1.response.news.NewsResponse;
import com.example.springjpa1.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/JPA1")
public class NewsController {
    @Autowired
    private INewsService iNewsService;
    @PostMapping("/new")
    public ResponseEntity<NewResponse> saveNews(@RequestBody NewRequest newRequest){
        NewResponse rsp = iNewsService.save(newRequest);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @GetMapping("/news")
    public ResponseEntity<NewsResponse> searchByTitle(@RequestParam(name = "title", required = false, defaultValue = "") String title){
        NewsResponse rsp = iNewsService.searchByTitle(title);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @PutMapping("/new/{id}")
    public ResponseEntity<NewResponse> updateNew(@PathVariable("id") Integer id, @RequestBody NewRequest newRequest){
        newRequest.setId(id);
        System.out.println("id = "+ id);
        NewResponse rsp = iNewsService.update(newRequest);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @GetMapping("/news/{id}")
    public ResponseEntity<NewResponse> getById(@PathVariable("id") Integer id){
        NewResponse rsp = iNewsService.getById(id);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }
    @DeleteMapping("new/{id}")
    public ResponseEntity<NewResponse> delete(@PathVariable("id") Integer id){
        NewResponse rsp = iNewsService.delete(id);
        return new ResponseEntity<>(rsp, HttpStatus.OK);
    }


}
