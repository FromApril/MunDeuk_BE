package com.example.MunDeuk.model;

import com.example.MunDeuk.dto.ForWriteRequestDto;
import com.example.MunDeuk.dto.LocationDTO;
import com.example.MunDeuk.dto.NoteDTO;
import com.example.MunDeuk.enums.NoteState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "notes")
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contents",length = 500)
    private String content;

    @Column
    private NoteState noteState;

    @Column
    private Long viewCount;

    @Column
    private Long likeCount;

    @Column
    private Double latitude;

    @Column
    private Double longitude;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Member ownerId;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Member originId;

    @Builder
    public Note(ForWriteRequestDto requestDto){
        this.content = requestDto.getContent();
        this.viewCount = 0L;
        this.noteState = NoteState.ACTIVE;
    }

    public void addViewCount(Note note){
        note.viewCount += 1;
    }

    public static Note createNote(NoteDTO noteDto, String userNick, LocationDTO locationDto){
        return null;
    }

}