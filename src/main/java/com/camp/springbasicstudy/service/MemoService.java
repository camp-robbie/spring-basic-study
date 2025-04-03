package com.camp.springbasicstudy.service;

import com.camp.springbasicstudy.controller.dto.CreateMemoRequestDto;
import com.camp.springbasicstudy.controller.dto.MemoResponseDto;

import java.util.List;

public interface MemoService {
    void save(CreateMemoRequestDto request);
    /**
     * 메모의 전체 데이터를 조회한다.
     * @return List<MemoResponseDto>
     */
    List<MemoResponseDto> getAll();
    MemoResponseDto getById(Long id);

}
