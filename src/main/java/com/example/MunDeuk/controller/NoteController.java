package com.example.MunDeuk.controller;

import com.example.MunDeuk.dto.ForWriteRequestDto;
import com.example.MunDeuk.dto.NoteResponseDto;
import com.example.MunDeuk.global.responseEntity.NoteResponseEntity;
import com.example.MunDeuk.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;
    private final NoteResponseEntity<NoteResponseDto> noteResponseEntity;

    @PostMapping("/feeds")
    @ResponseBody
    public NoteResponseEntity<?> createFeed(@RequestBody ForWriteRequestDto dto){
        return NoteResponseEntity.sucess(noteService.createFeed(dto));
    }
}
