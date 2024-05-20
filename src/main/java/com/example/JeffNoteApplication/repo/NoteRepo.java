package com.example.JeffNoteApplication.repo;

import com.example.JeffNoteApplication.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}
