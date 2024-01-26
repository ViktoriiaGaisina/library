package com.example.library.dao;

import com.example.library.dto.ReaderBookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Date;

@Repository
@RequiredArgsConstructor
public class BookReaderDao {
    private EntityManager entityManager;

    public void saveReader(ReaderBookDTO readerBookDTO) {
        entityManager.createNativeQuery("INSERT INTO book_reader(firstname, surname, start_reed_date,end_reed_date, book_reader_id_pk) VALUES(?, ?, ?, ?)")
                .setParameter(1, readerBookDTO.getFirstname())
                .setParameter(2, readerBookDTO.getSurname())
                .setParameter(3, readerBookDTO.getStartReed())
                .setParameter(4, readerBookDTO.getEndReed())
                .setParameter(5, readerBookDTO.getBookId());
        /*Пользователи должны иметь возможность выдавать книги читателям, отслеживать, какие книги в данный момент выданы*/
    }
}
