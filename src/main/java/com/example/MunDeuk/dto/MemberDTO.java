package com.example.MunDeuk.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class MemberDTO {

    private String user_id;
    private String password;
    private String email;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


}
