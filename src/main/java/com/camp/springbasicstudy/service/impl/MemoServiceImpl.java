package com.camp.springbasicstudy.service.impl;

import com.camp.springbasicstudy.controller.dto.CreateMemoRequestDto;
import com.camp.springbasicstudy.controller.dto.MemoResponseDto;
import com.camp.springbasicstudy.entity.Memo;
import com.camp.springbasicstudy.repository.MemoJpaRepository;
import com.camp.springbasicstudy.service.MemoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoServiceImpl implements MemoService {
    private final MemoJpaRepository memoJpaRepository;

    public MemoServiceImpl(MemoJpaRepository repository) {
        this.memoJpaRepository = repository;
    }

    @Override
    public void save(CreateMemoRequestDto request) {
        Memo memo = new Memo(request);
        memoJpaRepository.save(memo);
    }

    @Override
    public List<MemoResponseDto> getAll() {
        List<MemoResponseDto> memoResponseDtoList = new ArrayList<>();

        List<Memo> memoList = memoJpaRepository.findAll();
        for (Memo memo : memoList) {
            MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
            memoResponseDtoList.add(memoResponseDto);
        }

        return memoResponseDtoList;
    }

    @Override
    public MemoResponseDto getById(Long id) {
        // 아래 memo 객체는 테이블의 행(row)!
        // select * from memo where id = ?; <- JPA
        /**
         * select
         *         m1_0.id,
         *         m1_0.content,
         *         m1_0.title
         *     from
         *         memo m1_0
         *     where
         *         m1_0.id=?
         */
        Memo memo = memoJpaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not Found Memo")
        );
        // 람다 & 스트림, Exception (Checked Exception, UnChecked Exception)

        // Entity -> Dto
        MemoResponseDto responseDto = new MemoResponseDto(memo);
        return responseDto;
    }
}
