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
    /*Поиск книг: Пользователи должны иметь возможность искать книги по различным параметрам,
             таким как автор, название книги, жанр - если нужная книга не нашлась то нужно выдавать с похожим названием книгу/книги*/

    List<BookDTO> getBookEntityIsRead();
     /*Поиск книг которые в данный момент читают
     (выдавать список в порядке даты - то есть первым из списка выдается та книга которую только начали читать и тд ) */

    public void addBook(BookDTO bookDTO);

    public void updateBook(BookReaderupdateDTO readerupdateDTO);

    public void deleteBook(Long id);
}