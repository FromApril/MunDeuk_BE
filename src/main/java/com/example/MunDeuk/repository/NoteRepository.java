package com.example.MunDeuk.repository;

import com.example.MunDeuk.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query("select f from Feed f where f.createdAt < :threshold")
    Optional<List<Note>> findWithLocalTime(LocalDateTime threshold);
}
