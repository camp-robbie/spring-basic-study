package com.camp.springbasicstudy.entity;

import com.camp.springbasicstudy.controller.dto.CreateMemoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Memo {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    public Memo() {}

    public Memo(CreateMemoRequestDto request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
