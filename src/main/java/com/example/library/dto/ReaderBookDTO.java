package com.example.library.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReaderBookDTO {
    private String firstname;
    private String surname;
    private LocalDate date;
    private Long bookId;
}