package com.example.library.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BookReaderDao {
    private EntityManager entityManager;

    public void saveReader(String name, String surname, Long id) {
        entityManager.createNativeQuery("INSERT INTO book_reader(firstname, surname, book_reader_id_pk) VALUES(?, ?, ?)")
                .setParameter(1, name)
                .setParameter(2, surname)
                .setParameter(3, id);
    }
}
