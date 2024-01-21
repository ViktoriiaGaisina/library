package com.example.library.service;

import com.example.library.dto.bookreader.BookReaderDTO;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookReaderService {
    List<BookReaderDTO> getBookReaderEntities(String firstname, String surname);

    void registerBookTakenByReader(String firsname, String surname, LocalDate registrationDate, Long bookId);
}

