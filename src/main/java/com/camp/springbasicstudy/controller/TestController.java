package com.camp.springbasicstudy.controller;

import com.camp.springbasicstudy.controller.dto.MemoResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
public class TestController {

    // Spring -> Model model = new Model의 구현체();
    // GET http://localhost:8081/hello?name={이귀현}, testController.test({이귀현}, model);
    @GetMapping("/hello")
    public String test(
            @RequestParam String name,
            Model model
    ) {
        System.out.println("name = " + name);
        model.addAttribute("name", name);
        return "hello"; // hello.html
    }

    @ResponseBody
    @GetMapping("/json")
    public List<MemoResponseDto> test2() {
        MemoResponseDto memoResponseDto =new MemoResponseDto();
        memoResponseDto.setId(1L);
        memoResponseDto.setTitle("제목");
        memoResponseDto.setContent("내용");
        // JSON: memoResponseDto => {'id': 1, 'title': 'ㅈㅔ목', 'content': '내용'}, Jackson
//        return "{'id': 1, 'title': 'ㅈㅔ목', 'content': '내용'}";
        return List.of(memoResponseDto, new MemoResponseDto());
    }

}