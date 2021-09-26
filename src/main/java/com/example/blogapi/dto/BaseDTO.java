package com.example.blogapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {

    private long id;
    private Date createdDate;
    private Date modifileDate;
}
