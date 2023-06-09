package com.example.MunDeuk.service;

import com.example.MunDeuk.dto.LocationDTO;
import com.example.MunDeuk.dto.NoteDTO;
import com.example.MunDeuk.model.Note;
import com.example.MunDeuk.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    @Transactional
    public Long write(NoteDTO noteDto, String userNick, LocationDTO locationDto){
        try{
            Note note = Note.createNote(noteDto, userNick, locationDto);
            return note.getId();

        } catch(Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }
    }

    //게시글 수정시
    @Transactional
    public Long modify(NoteDTO noteDTO, String userNick, LocationDTO locationDTO){
        try{
            Note note = noteRepository.findById(noteDTO.getNote_id()).get();

            if(note.getUserNick().equals(noteDTO.getUserNick())){
                //사용자 불일치시(예외처리)
                return null;
            }else{
                //수정한다.
                note.modifyNote(note, noteDTO);
            }
        }catch (Exception e){

        }
        return null;
    }

    //조회시 viewCount + 1
    @Transactional
    public Long updateView(NoteDTO noteDTO){
        try{
            Note note = noteRepository.findById(noteDTO.getNote_id()).get();
            int viewCount = note.getViewCount() + 1;

            note.updateView(note, viewCount);

        }catch (Exception e){

        }
        return null;
    }

}
