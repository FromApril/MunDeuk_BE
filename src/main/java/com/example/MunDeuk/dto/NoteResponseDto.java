package com.example.MunDeuk.dto;

import com.example.MunDeuk.model.Member;
import com.example.MunDeuk.model.Note;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class NoteResponseDto {

    private String writer;
    private String contents;
//  private String title;
//  private String image;
//  private String soundtrack;


    public NoteResponseDto(Note note, Member member) {
        this.setWriter(member.getUsername());
        this.setContents(note.getContent());
    }
}
