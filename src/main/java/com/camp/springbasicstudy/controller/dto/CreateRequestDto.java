package com.camp.springbasicstudy.controller.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateRequestDto {
    private String title;
    private String content;
}
