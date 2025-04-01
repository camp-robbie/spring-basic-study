package com.camp.springbasicstudy.controller;


import com.camp.springbasicstudy.controller.dto.CreateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoController {

    // POST http://localhost:8081/api/memos payload: "{ 'title': 'JPA 공부', 'content': '영속성 컨텍스트 정리' }" => new CreateRequestDto(데이터);
    @PostMapping("/api/memos")
    public ResponseEntity<Void> save(@RequestBody CreateRequestDto request) { // Spring -> memoController.save(request), CreateRequestDto request =  new CreateRequestDto(데이터);
        System.out.println("request = " + request.toString());
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201
    }

}
