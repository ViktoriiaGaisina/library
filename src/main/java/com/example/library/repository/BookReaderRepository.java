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
            @Param("surname") String surname/*Поиск читателей: Пользователи должны иметь возможность искать читателей по имени и фамилии
если нужный читатель не нашелся то нужно выдавать с похожим названием читателя/читателей*/
    );
    List<BookReaderEntity> findBookReaderEntitiesByBook_Id(Long id);
}
