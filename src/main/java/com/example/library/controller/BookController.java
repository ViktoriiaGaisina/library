package com.example.library.controller;

import com.example.library.dto.book.BookDTO;
import com.example.library.dto.bookreader.BookReaderupdateDTO;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/search")
    public List<BookDTO> getBookEntityBy(
            @RequestParam(name = "name_book") String name,
            @RequestParam(name = "name-author") String nameAuthor,
            @RequestParam(name = "genre") String genre
    ) {
        return bookService.getBookEntities(name, nameAuthor, genre);
    }

    @GetMapping("/is-read")
    public List<BookDTO> getBookEntityIsRead() {
        return bookService.getBookEntityIsRead();
    }

    @GetMapping("/{bookId}/delete")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/update")
    public void updateBook(@RequestBody BookReaderupdateDTO bookReaderupdateDTO) {
        bookService.updateBook(bookReaderupdateDTO);
    }

    @PostMapping("/save")
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }
}

