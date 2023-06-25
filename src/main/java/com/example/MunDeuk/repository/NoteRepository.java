package com.example.MunDeuk.repository;

import com.example.MunDeuk.dto.LocationDTO;
import com.example.MunDeuk.enums.NoteState;
import com.example.MunDeuk.model.Note;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {


    @Query("select n from Note n where n.createdAt < :threshold")
    Optional<List<Note>> findWithLocalTime(LocalDateTime threshold);

    @Query("SELECT n FROM Note n " +
            "WHERE CAST(n.id AS varchar) NOT IN :viewNoteIdList " +
            "AND ST_DWithin(ST_MakePoint(n.longitude, n.latitude), ST_MakePoint(:longitude, :latitude), :radius * 1000) " +
            "AND n.isDeleted = false " +
            "LIMIT :size")
    List<Note> findNotesWithInDistance(LocationDTO locationDto);


    @Transactional
    default void unlikeQuery(Long noteId) {
        Note note = findById(noteId).orElse(null);
        if (note != null) {
            note.setLikeCount(note.getLikeCount() - 1);
            save(note);
        }
    }

    @Transactional
    default void likeQuery(Long noteId) {
        Note note = findById(noteId).orElse(null);
        if (note != null) {
            note.setLikeCount(note.getLikeCount() + 1);
            save(note);
        }
    }

    @Transactional
    default void softDelete(Long noteId) {
        Note note = findById(noteId).orElse(null);
        if (note != null) {
            note.setNoteState(NoteState.DELETED);
            save(note);
        }
    }

}
