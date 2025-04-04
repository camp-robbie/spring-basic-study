package com.camp.springbasicstudy.entity;

import com.camp.springbasicstudy.controller.dto.CreateMemoRequestDto;
import com.camp.springbasicstudy.controller.dto.UpdateMemoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
public class Memo extends BaseEntity {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15, nullable = false)
    private String author;
    @Column(length = 150, nullable = false)
    private String title;
    @Column(length = 500, nullable = false)
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Memo() {}

    public Memo(CreateMemoRequestDto request) {
        this.title = request.getTitle();
        this.author = request.getAuthor();
        this.content = request.getContent();
        this.createdAt = request.getUpdatedAt();
        this.updatedAt = request.getUpdatedAt();
    }

    public void update(UpdateMemoRequestDto request) {
        this.author = request.getAuthor();
        this.title = request.getTitle();
        this.content = request.getContent();
        this.updatedAt = request.getUpdatedAt();
    }

}
