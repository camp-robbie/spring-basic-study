package com.camp.springbasicstudy.entity;

import com.camp.springbasicstudy.controller.dto.CreateRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
// @Table(name = "memo")
public class Memo {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4, 5 자동으로 번호 증가 = AutoIncrement
    private Long id;

    private String title; // DB 의 컬럼이랑 매칭이된다.
    private String content; // DB 의 컬럼이랑 매칭이된다.

    public Memo() {}

    public Memo(CreateRequestDto request) {
        // 가져온 데이터를 필드에 바인딩해서 객체를 생성
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
