package com.example.springjpa1.response.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewResponse {
    private Integer id;
    private String title;
    private String content;
    private String thumbnail;
    private String shortDescription;
    private Integer categoryId;
}
