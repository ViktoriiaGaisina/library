package com.example.library.service;

import com.example.library.dto.ReaderBookDTO;
import com.example.library.dto.bookreader.BookReaderDTO;
import com.example.library.entity.BookReaderEntity;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookReaderService {
    List<BookReaderDTO> getBookReaderEntities(String firstname, String surname);

    void registerBookTakenByReader(ReaderBookDTO readerBookDTO);
    List<BookReaderDTO> findBookReaderEntitiesByBook_Id(Long id);
}

