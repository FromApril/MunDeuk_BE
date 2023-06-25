package com.example.MunDeuk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locker")
@Data
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "saved_notes")
    private List<Note> savedNotes;


    public void savedNotesInit(){
        this.savedNotes = new ArrayList<>();
    }
}
