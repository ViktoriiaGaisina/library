package com.example.library.controller;

import com.example.library.dto.ReaderBookDTO;
import com.example.library.dto.bookreader.BookReaderDTO;
import com.example.library.entity.BookReaderEntity;
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
    @GetMapping("{id}/all")
    public List<BookReaderDTO> findBookReaderEntitiesByBook_Id(
            @PathVariable(name = "id") Long id) {
                return bookReaderService.findBookReaderEntitiesByBook_Id(id);
    }

    @PostMapping("/save")
    public void saveReader(@RequestBody ReaderBookDTO readerBookDTO) {
        bookReaderService.saveReader(readerBookDTO);
    }

}
