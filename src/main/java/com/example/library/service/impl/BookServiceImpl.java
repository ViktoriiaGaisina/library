package com.example.library.service.impl;

import com.example.library.dao.BookDao;
import com.example.library.dto.book.BookDTO;
import com.example.library.dto.bookreader.BookReaderupdateDTO;
import com.example.library.entity.BookEntity;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookDao bookDao;

    @Override
    public List<BookDTO> getBookEntities(String name, String nameAuthor, String genre) {
        if (name.isEmpty() && nameAuthor.isEmpty() && genre.isEmpty()) {
            return new ArrayList<>();
        }
        return bookRepository.findBookEntities(name, nameAuthor, genre).stream()
                .map(tmp -> BookDTO.builder()
                        .name(tmp.getName())
                        .genre(tmp.getGenre())
                        .nameAuthor(tmp.getNameAuthor())
                        .bookId(tmp.getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBookEntityIsRead() {
        return bookRepository.findBookEntityIsRead().stream()
                .map(tmp -> BookDTO.builder()
                        .name(tmp.getName())
                        .genre(tmp.getGenre())
                        .nameAuthor(tmp.getNameAuthor())
                        .bookId(tmp.getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void addBook(BookDTO bookDTO) {
        BookEntity bookEntity = BookEntity.builder()
                .name(bookDTO.getName())
                .genre(bookDTO.getGenre())
                .nameAuthor(bookDTO.getNameAuthor())
                .build();
        bookRepository.save(bookEntity);
//        bookDao.addBook(
//                bookDTO.getName(),
//                bookDTO.getGenre(),
//                bookDTO.getNameAuthor()
//        );
    }

    @Override
    public void updateBook(BookReaderupdateDTO bookReaderupdateDTO) {
        bookDao.update(bookReaderupdateDTO);
    }

    @Override
    public void deleteBook(Long id) {
        bookDao.deleteBook(id);
    }

}
