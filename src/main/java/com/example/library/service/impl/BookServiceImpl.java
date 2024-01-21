package com.example.library.service.impl;

import com.example.library.dto.book.BookDTO;
import com.example.library.dto.bookreader.BookReaderDTO;
import com.example.library.entity.BookReaderEntity;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<BookDTO> getBookEntities(String name, String nameAuthor, String genre) {
        if(name.isEmpty() && nameAuthor.isEmpty() && genre.isEmpty()) {
            return new ArrayList<>();
        }
        return bookRepository.findBookEntities(name, nameAuthor, genre).stream()
                .map(tmp ->BookDTO.builder()
                        .name(tmp.getName())
                        .genre(tmp.getGenre())
                        .nameAuthor(tmp.getNameAuthor())
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
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<BookReaderDTO> getReadersBookById(Long bookId) {
        List<BookReaderEntity> bookReaderEntities = bookRepository.findReadersBookById(bookId);
        return bookReaderEntities.stream()
                .map(tmp -> BookReaderDTO.builder()
                        .firstname(tmp.getFirstname())
                        .surname(tmp.getSurname())
                        .date(tmp.getDate())
                        .build())
                .collect(Collectors.toList());
    }

}
