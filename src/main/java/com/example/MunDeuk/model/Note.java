package com.example.MunDeuk.model;

import com.example.MunDeuk.dto.NoteDTO;
import com.example.MunDeuk.dto.LocationDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * The type Feed.
 */
//@EqualsAndHashCode(callSuper = true) **이거 뭐임?
@Data
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="feed_id")
    private Long id;

    @Column
    private String content;

    @Column
    private String imageUrl;

    @Column
    private String musicUrl;

    @Column
    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    private String userNick;

    @Column
    private String latitude;                /* 위도 */

    @Column
    private String longitude;               /* 경도 */

    @Column
    private int viewCount;

    @Column
    private int likeCount;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime modifiedAt;

    /**
     * Note 생성 메소드
     *
     * @author Wonjun Choi
     *
     * @param noteDto     노트의 텍스트 내용, 업로드된 이미지 URL, 음악 URL
     * @param userNick    사용자 정보
     * @param locationDto 위치정보(위도, 경도)
     * @return note       생성된 노트 객체
     *
     * @exception
     * @See
     */
    public static Note createNote(NoteDTO noteDto, String userNick, LocationDTO locationDto) {

        Note note = new Note() ;

        note.setContent(noteDto.getContent());
        note.setImageUrl(noteDto.getImageUrl());
        note.setMusicUrl(noteDto.getMusicUrl());
        note.setUserNick(userNick);
        note.setLatitude(locationDto.getLatitude());
        note.setLongitude(locationDto.getLongitude());
        note.setIsDeleted(false);
        note.setViewCount(0);
        note.setLikeCount(0);
        note.setCreatedAt(LocalDateTime.now());
        note.setModifiedAt(LocalDateTime.now());

        return note;
    }

    //노트 수정
    public static Note modifyNote(Note note, NoteDTO noteDto){

        note.setContent(noteDto.getContent());
        note.setImageUrl(noteDto.getImageUrl());
        note.setMusicUrl(noteDto.getMusicUrl());
        note.setModifiedAt(LocalDateTime.now());

        return note;
    }


    //viewCount update
    public void updateView(Note note, int viewCount) {
        note.setViewCount(viewCount);
    }
}
