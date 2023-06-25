package com.example.MunDeuk.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class NoteDTO {

    private final String userNick;
    private final String content;
    private final String imageUrl;
    private final String musicUrl;
}
