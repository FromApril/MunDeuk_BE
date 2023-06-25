package com.example.MunDeuk.global.responseEntity;

import com.example.MunDeuk.global.errors.MunDeukRuntimeException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Setter
@Getter
@RequiredArgsConstructor
@Component
public class NoteResponseEntity<T> {

    private HttpStatus httpStatus;
    private T body;
    private String msg;

    public NoteResponseEntity(HttpStatus status, Object o, String message) {
    }

    public static <T> NoteResponseEntity<T> sucess(T body) {
        return new NoteResponseEntity<>(HttpStatus.OK, body, "성공");
    }

    public static <T> NoteResponseEntity<T> fail(MunDeukRuntimeException e) {
        return new NoteResponseEntity<>(e.getErrorCode().getHttpStatus(), null, e.getErrorCode().getMessage());
    }

    public static <T> NoteResponseEntity<T> error(HttpStatus status, String message) {
        return new NoteResponseEntity<>(status, null, message);
    }


}
