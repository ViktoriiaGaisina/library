package com.example.library.dao;

import com.example.library.dto.bookreader.BookReaderupdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BookDao {
    private EntityManager entityManager;

    public void addBook(String name, String genre, String nameAuthor) {
         entityManager.createNativeQuery("INSERT INTO book(name, genre, name_author) VALUES(?, ?, ?)")
                .setParameter(1, name)
                .setParameter(2, genre)
                .setParameter(3, nameAuthor);
    }

    public void deleteBook(Long id) {
         entityManager.createNativeQuery("DELETE FROM book WHERE (book_id_pk) = ?")
                .setParameter(1, id);
    }
    public void update(BookReaderupdateDTO readerupdateDTO) {
        entityManager.createNativeQuery("UPDATE book SET name = ?, genre = ?, name_author = ? WHERE book_id_pk = ?  ")
                .setParameter(1, readerupdateDTO.getName())
                .setParameter(2,readerupdateDTO.getGenre())
                .setParameter(3, readerupdateDTO.getNameAuthor())
                .setParameter(4,readerupdateDTO.getId());

    }
}
