package com.camp.springbasicstudy.service.impl;

import com.camp.springbasicstudy.controller.dto.CreateMemoRequestDto;
import com.camp.springbasicstudy.controller.dto.MemoResponseDto;
import com.camp.springbasicstudy.entity.Memo;
import com.camp.springbasicstudy.repository.MemoJpaRepository;
import com.camp.springbasicstudy.service.MemoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
