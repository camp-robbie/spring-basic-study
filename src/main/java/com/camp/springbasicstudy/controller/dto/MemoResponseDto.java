package com.camp.springbasicstudy.controller.dto;

import com.camp.springbasicstudy.entity.Memo;
import lombok.Getter;

@Getter
//@AllArgsConstructor
public class MemoResponseDto {
    private Long id; // PK
    private String title; // 제목
    private String content; // 내용

    // this 와 this()
    public MemoResponseDto(Memo memo) {
        this(memo.getId(), memo.getTitle(), memo.getContent());
    }

    public MemoResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
