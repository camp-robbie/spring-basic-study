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

// CRUD : CRATE, READ, UPDATE, DELETE


@RestController
public class MemoController {

    // @Autowired // Spring 나 필요해!
    private final MemoService memoService;

    // @Autowired // 의존성 주입! DI -> 필요한 객체를 외부에서 받아온다. (Spring)
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }
    // MemoController memoController = new MemoController(컨테이너에서 MemoService 타입의 Bean을 찾아서 넣어준다!);

    // POST http://localhost:8081/api/memos payload: "{ 'title': 'JPA 공부', 'content': '영속성 컨텍스트 정리' }" => new CreateRequestDto(데이터);
    // 3계층 -> Controller -> Service -> Repository
    // Controller 는 Client 의 요청을 받고 결과물을 Client에 전달한다. -> Controller 의 책임
    // SRP-> 단일 책임 원칙
    @PostMapping("/api/memos")
    public ResponseEntity<Void> save(@RequestBody CreateRequestDto request) { // Spring -> memoController.save(request), CreateRequestDto request =  new CreateRequestDto(데이터);
        // Controller Client 의 요청을 받고 실제 해당 요청의 작업은 Service 계층에 넘긴다.
        // MemoService service = new MemoServiceImpl(); // => Spring 이 만들어서 어딘가(컨테이너)에 저장해두고 우리가 필요하다고 하면 준다. (Bean)
        memoService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201
    }

    @GetMapping("/api/memos")
    public List<MemoResponseDto> getAll() {
        return memoService.getAll();
    }


}
