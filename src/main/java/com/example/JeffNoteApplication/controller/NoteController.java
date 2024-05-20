package com.example.JeffNoteApplication.controller;

import com.example.JeffNoteApplication.model.Note;
import com.example.JeffNoteApplication.repo.NoteRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
public class NoteController {

    @Autowired
    private NoteRepo noteRepo;

    @PostMapping("/notes")
    public ResponseEntity<Note> addNote(@Valid @RequestBody Note note){

        Note noteObj = noteRepo.save(note);

        return new ResponseEntity<>(noteObj, HttpStatus.CREATED);
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes(){

        try{
            List<Note> noteList = new ArrayList<>();
            noteList.addAll(noteRepo.findAll());

            if(noteList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(noteList, HttpStatus.OK);
        }catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable Long id){

        Optional<Note> noteData = noteRepo.findById(id);

        if(noteData.isPresent()){
            return new ResponseEntity<>(noteData, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNoteById(@PathVariable Long id, @Valid @RequestBody Note updatedNoteData){

        Optional<Note> curNoteData =  noteRepo.findById(id);

        if(curNoteData.isPresent()){
            Note updatedNote = curNoteData.get();
            updatedNote.setTitle(updatedNoteData.getTitle());
            updatedNote.setContent(updatedNoteData.getContent());

            Note noteObj = noteRepo.save(updatedNote);

            return new ResponseEntity<>(noteObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<ResponseStatus> deleteNoteById(@PathVariable Long id){

        Optional<Note> noteData = noteRepo.findById(id);

        if(noteData.isPresent()){
            noteRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
