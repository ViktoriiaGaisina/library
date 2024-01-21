package com.example.library.repository;

import com.example.library.dto.bookreader.BookReaderDTO;
import com.example.library.entity.BookReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookReaderRepository extends JpaRepository<BookReaderEntity, Long> {
    @Query(value = "SELECT * FROM book_reader WHERE firstname ILIKE :%firstname AND surname ILIKE :%surname",
            nativeQuery = true)
    List<BookReaderEntity> findBookReaderEntities(
            @Param("firstname") String firstname,
            @Param("surname") String surname
    );

    @Query(value = "INSERT INTO book_reader (firstname, surname, registration_date, book_id_fk) VALUES (:firstname, :surname, :registrationDate, :bookId)", nativeQuery = true)
    BookReaderDTO registerBookTakenByReader(
            @Param("firstname") String firstname,
            @Param("surname") String surname,
            @Param("registrationDate") LocalDate registrationDate,
            @Param("bookId") Long bookId
    );

}
