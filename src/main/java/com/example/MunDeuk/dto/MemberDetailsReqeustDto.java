package com.example.MunDeuk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberDetailsReqeustDto {
    private String nickname;
    private String email;
}