package com.camp.springbasicstudy.controller.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CreateMemoRequestDto {
    private String title;
    private String content;
}
