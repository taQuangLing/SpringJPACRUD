package com.example.springjpa1.response.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class NewsResponse {
    List<NewResponse> news;
    public NewsResponse(){
        news = new ArrayList<>();
    }
}
