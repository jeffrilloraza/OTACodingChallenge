package com.example.JeffNoteApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name="Notes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    private String content;
}
