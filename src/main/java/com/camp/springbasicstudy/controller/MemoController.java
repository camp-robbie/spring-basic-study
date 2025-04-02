package com.camp.springbasicstudy.controller;


import com.camp.springbasicstudy.controller.dto.CreateRequestDto;
import com.camp.springbasicstudy.controller.dto.MemoResponseDto;
import com.camp.springbasicstudy.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping("/api/memos")
    public ResponseEntity<Void> save(@RequestBody CreateRequestDto request) {
        memoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/api/memos")
    public List<MemoResponseDto> getAll() {
        return memoService.getAll();
    }

}
