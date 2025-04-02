package com.camp.springbasicstudy.service;

import com.camp.springbasicstudy.controller.dto.CreateRequestDto;
import com.camp.springbasicstudy.controller.dto.MemoResponseDto;

import java.util.List;

public interface MemoService {
    // 기능 선언 -> 메서드 선언
    // 1. 일반적인 메모 로직 구현체 MemoServiceBasicImpl
    // 2. 프리미엄 메모 로직 구현체 MemoServicePrmImpl <- 14:00, 이걸 시간으로 인식해서 알림 설정이 자동으로 됨.
    void save(CreateRequestDto request);
    // 무조건 하나의 구현체만 존재! -> 1대1 추상화!, Convention 기반

    /**
     * 메모의 전체 데이터를 조회한다.
     * @return List<MemoResponseDto>
     */
    List<MemoResponseDto> getAll();


}
