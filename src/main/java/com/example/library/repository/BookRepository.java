package com.example.library.repository;

import com.example.library.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query(value ="SELECT * FROM book WHERE name = :name AND name_author = :name_author AND genre = :genre",
            nativeQuery = true)
    List<BookEntity> findBookEntityBy(
            @Param("name") String name,
            @Param("name_author") String nameAuthor,
            @Param("genre") String genre
    );
}
