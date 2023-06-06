package com.example.MunDeuk.service;

import com.example.MunDeuk.dto.LocationDTO;
import com.example.MunDeuk.dto.NoteDTO;
import com.example.MunDeuk.model.Note;
import com.example.MunDeuk.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    @Transactional
    public Long write(NoteDTO noteDto, String userNick, LocationDTO locationDto){

        Note note = Note.createNote(noteDto, usergNick, locationDto);
        return note.getId();
    }
}
