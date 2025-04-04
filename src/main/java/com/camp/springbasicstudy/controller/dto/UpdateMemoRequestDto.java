package com.camp.springbasicstudy.controller.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateMemoRequestDto {
    private String title;
    private String author;
    private String content;
    private LocalDateTime updatedAt;

}
