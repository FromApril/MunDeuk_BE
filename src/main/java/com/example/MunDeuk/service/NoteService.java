package com.example.MunDeuk.service;

import com.example.MunDeuk.dto.ForWriteRequestDto;
import com.example.MunDeuk.dto.LocationDTO;
import com.example.MunDeuk.dto.NoteDTO;
import com.example.MunDeuk.dto.NoteResponseDto;
import com.example.MunDeuk.global.errors.CustomErrorCode;
import com.example.MunDeuk.global.errors.MunDeukRuntimeException;
import com.example.MunDeuk.model.Member;
import com.example.MunDeuk.model.Note;
import com.example.MunDeuk.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional
    public Long write(NoteDTO noteDto, String userNick, LocationDTO locationDto){

        Note note = Note.createNote(noteDto, userNick, locationDto);
        return note.getId();
    }

    @Transactional
    public NoteResponseDto createFeed(ForWriteRequestDto dto) {
        Note note = Note.builder().requestDto(dto).build();
        Member writer = new Member();
        return new NoteResponseDto(noteRepository.save(note), writer);
    }

    @Transactional(readOnly = true)
    public NoteResponseDto readFeed(Long noteId) {
        Note found = noteRepository.findById(noteId)
                .orElseThrow(() -> new MunDeukRuntimeException(CustomErrorCode.NOTE_NOT_FOUND));
        Member writer = new Member();
        return new NoteResponseDto(found,writer);
    }

    public List<Note> findNotesWithInDistance(ForWriteRequestDto dto){

        LocationDTO locationDTO = new LocationDTO(dto.getLatitude(), dto.getLongitude());
        List<Note> noteList = noteRepository.findNotesWithInDistance(locationDTO);

        if(noteList.isEmpty()){
            //조회된 노트가 없을 때 처리
        }else{
            //노트가 있으면,

            //횟수도 보내주어야 할 것 같다.
            int cnt = noteList.size();
        }

        return noteList;
    }
}
