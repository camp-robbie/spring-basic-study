package com.camp.springbasicstudy.controller.dto;

import com.camp.springbasicstudy.entity.Memo;
import lombok.Getter;

@Getter

public class MemoResponseDto {
    private Long id;
    private String title;
    private String content;

    public MemoResponseDto(Memo memo) {
        this(memo.getId(), memo.getTitle(), memo.getContent());
    }

    public MemoResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
