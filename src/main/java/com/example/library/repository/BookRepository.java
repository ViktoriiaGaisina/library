package com.example.library.repository;

import com.example.library.entity.BookEntity;
import com.example.library.entity.BookReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query(value = "SELECT * FROM book WHERE name ILIKE :%name AND name_author ILIKE :%name_author AND genre ILIKE :%genre",
            nativeQuery = true)
    List<BookEntity> findBookEntities(
            @Param("name") String name,
            @Param("name_author") String nameAuthor,
            @Param("genre") String genre
            /*Поиск книг: Пользователи должны иметь возможность искать книги по различным параметрам,
             таким как автор, название книги, жанр - если нужная книга не нашлась то нужно выдавать с похожим названием книгу/книги*/
    );

    @Query(value = "SELECT * FROM book" +
            " JOIN book_reader on book.book_id_pk = book_reader.book_id_fk " +
            "ORDER BY book_reader.registration_date DESC",
            nativeQuery = true)
    List<BookEntity> findBookEntityIsRead();
    /*Поиск книг которые в данный момент читают
     (выдавать список в порядке даты - то есть первым из списка выдается та книга которую только начали читать и тд ) */

    @Query(value = "UPDATE book SET name = :name, genre = :genre, name_author = :nameAuthor WHERE book_id_pk = :id",
            nativeQuery = true)
    void updateBook(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("genre") String genre,
            @Param("nameAuthor") String nameAuthor
    );

}

