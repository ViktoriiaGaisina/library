package com.example.library.service;

import com.example.library.dto.ReaderBookDTO;
import com.example.library.dto.book.BookDTO;
import com.example.library.dto.bookreader.BookReaderDTO;
import com.example.library.dto.bookreader.BookReaderupdateDTO;
import com.example.library.entity.BookReaderEntity;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookReaderService {
    List<BookReaderDTO> getBookReaderEntities(String firstname, String surname);
    /*Поиск читателей: Пользователи должны иметь возможность искать читателей по имени и фамилии
    eсли нужный читатель не нашелся то нужно выдавать с похожим названием читателя/читателей*/

    void saveReader(ReaderBookDTO readerBookDTO);
    /*Поиск книг которые в данный момент читают
     (выдавать список в порядке даты - то есть первым из списка выдается та книга которую только начали читать и тд ) и еще небольшое условие
      когда читатель взял книгу читать то присваивается читателю дата когда он взял эту книгу
      дата присваивается автоматически*/
    List<BookReaderDTO> findBookReaderEntitiesByBook_Id(Long id);
    /*Пользователи должны иметь возможность выдавать книги читателям, отслеживать, какие книги в данный момент выданы*/
     void updateBookReader(ReaderBookDTO readerBookDTO);

     void deleteBookReader(Long id);
}

