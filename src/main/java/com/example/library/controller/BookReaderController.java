package com.example.library.controller;

import com.example.library.dto.bookreader.BookReaderDTO;
import com.example.library.service.BookReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/booksreaders")
@RequiredArgsConstructor
public class BookReaderController {
    private final BookReaderService bookReaderService;

    @GetMapping("/search")
    public List<BookReaderDTO> getBookReaderEntities(
            @RequestParam(name = "firstname") String firstname,
            @RequestParam(name = "surname") String surname
    ) {
        return bookReaderService.getBookReaderEntities(firstname, surname);
    }

    @PostMapping("/save")
    public void registerBookTakenByReader(
            @RequestParam(name = "firstname") String firsname,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "registrationDate") LocalDate registrationDate,
            @PathVariable(name = "bookId") Long bookId
    ) {
        bookReaderService.registerBookTakenByReader(firsname, surname, registrationDate, bookId);
    }

}
