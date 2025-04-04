package com.camp.springbasicstudy.controller.dto;

import com.camp.springbasicstudy.entity.Memo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class MemoResponseDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime updatedAt;

    public MemoResponseDto(Memo memo) {
        this(memo.getId(), memo.getAuthor(), memo.getTitle(), memo.getContent(), memo.getUpdatedAt());
    }

    public MemoResponseDto(Long id, String author, String title, String content, LocalDateTime updatedAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.updatedAt = updatedAt;
    }

}
