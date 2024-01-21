package com.example.library.dto.bookreader;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class BookReaderDTO {
    private String firstname;
    private String surname;
    private LocalDate date;
}
