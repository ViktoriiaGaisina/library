package com.example.library.dto.book;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class BookDTO {
    private Long bookId;
    private String name;
    private String genre;
    private String nameAuthor;
}
