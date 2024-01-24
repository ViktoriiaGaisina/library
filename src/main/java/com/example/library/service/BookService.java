package com.example.library.service;

import com.example.library.dto.book.BookDTO;
import com.example.library.dto.bookreader.BookReaderDTO;
import com.example.library.dto.bookreader.BookReaderupdateDTO;
import com.example.library.entity.BookEntity;
import com.example.library.entity.BookReaderEntity;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookService {
    List<BookDTO> getBookEntities(String name, String nameAuthor, String genre);

    List<BookDTO> getBookEntityIsRead();

    public void addBook(BookDTO bookDTO);

    public void updateBook(BookReaderupdateDTO readerupdateDTO);

    public void deleteBook(Long id);
}