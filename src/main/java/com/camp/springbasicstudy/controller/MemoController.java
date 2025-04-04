package com.camp.springbasicstudy.controller;


import com.camp.springbasicstudy.controller.dto.CreateMemoRequestDto;
import com.camp.springbasicstudy.controller.dto.MemoResponseDto;
import com.camp.springbasicstudy.controller.dto.UpdateMemoRequestDto;
import com.camp.springbasicstudy.service.MemoService;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping("/api/memos")
    public ResponseEntity<Void> save(@RequestBody CreateMemoRequestDto request) {
        memoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/api/memos")
    public List<MemoResponseDto> getAll() {
        return memoService.getAll();
    }

    // 아래 1은 무슨 의미인지? -> 메모의 고유 식별값, 즉 id 따라서 항상 바뀔 수 있다.
    // http://localhost:8081/api/memos/1
    // 위 API는 브라우저에서 서버에게 1번 메모 정보를 주세요!
    @GetMapping("/api/memos/{id}")
    public MemoResponseDto getById(
           @PathVariable Long id
    ) {
        MemoResponseDto responseDto = memoService.getById(id);
        /**
         * {
         * "id": 1,
         * "title": "제목1",
         * "content": "내용1"
         * }
         */
        return responseDto;
    }

    @PutMapping("/api/memos/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateMemoRequestDto request) {
        memoService.update(id, request);
    }

    @DeleteMapping("/api/memos/{id}")
    public void delete(@PathVariable Long id) {
        memoService.delete(id);
    }

}
