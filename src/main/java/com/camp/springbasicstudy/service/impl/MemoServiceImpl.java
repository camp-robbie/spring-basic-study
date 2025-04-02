package com.camp.springbasicstudy.service.impl;

import com.camp.springbasicstudy.controller.dto.CreateRequestDto;
import com.camp.springbasicstudy.controller.dto.MemoResponseDto;
import com.camp.springbasicstudy.entity.Memo;
import com.camp.springbasicstudy.repository.MemoJpaRepository;
import com.camp.springbasicstudy.service.MemoService;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @Component
@Service
public class MemoServiceImpl implements MemoService {
    // private final MemoJpaRepository repository = new SimpleJpaRepository<Memo, Long>();
    private final MemoJpaRepository memoJpaRepository;

    public MemoServiceImpl(MemoJpaRepository repository) {
        this.memoJpaRepository = repository;
    }

    @Override
    public void save(CreateRequestDto request) {
        // request -> 저장할 Memo 데이터를 가지고 있다.
        // request -> entity(table)
        Memo memo = new Memo(request); // 받아온 데이터를 가지고 있는 Entity 객체
        // 저장!!! DB 연결해서 실제로 쿼리 execute 해서 결과 가져오고! => Repository 역할
        memoJpaRepository.save(memo); // insert 쿼리 : insert into memo (content, title)  values(?, ?);
    }

    @Override
    public List<MemoResponseDto> getAll() {
        // Memo memo = new Memo(); -> 테이블의 1row
        // List<Memo> memoList -> 테이블 전체 row, memo 객체 여러개
        /**
         * select
         *         m1_0.id,
         *         m1_0.content,
         *         m1_0.title
         *     from
         *         memo m1_0
         */

        List<Memo> memoList = memoJpaRepository.findAll(); // 테이블 전체 row -> JPA
        List<MemoResponseDto> memoResponseDtoList = new ArrayList<>(); // Client에 반환할 List

        for (Memo memo : memoList) {
            MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
            memoResponseDtoList.add(memoResponseDto);
        }

        return memoResponseDtoList;
//      return memoJpaRepository.findAll().stream().map(MemoResponseDto::new).toList(); // 이렇게 해야만 한다가 아닙니다. 나중에 하셔도 됩니다. 지금은 이해하기 쉽게 짜는게 좋다.
    }
}
