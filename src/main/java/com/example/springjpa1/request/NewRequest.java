package com.example.springjpa1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewRequest {
    private Integer id;
    private String title;
    private String content;
    private String thumbnail;
    private String shortDescription;
    private String categoryCode;
}
