package com.example.library.service.impl;

import com.example.library.dto.ReaderBookDTO;
import com.example.library.dto.bookreader.BookReaderDTO;
import com.example.library.entity.BookReaderEntity;
import com.example.library.repository.BookReaderRepository;
import com.example.library.service.BookReaderService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookReaderServiceImpl implements BookReaderService {
    private final BookReaderRepository bookReaderRepository;

    @Override
    public List<BookReaderDTO> getBookReaderEntities(String firstname, String surname) {
        return bookReaderRepository.findBookReaderEntities(firstname, surname).stream()
                .map(tmp -> BookReaderDTO.builder()
                        .firstname(tmp.getFirstname())
                        .surname(tmp.getSurname())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public void registerBookTakenByReader(ReaderBookDTO readerBookDTO) {
        bookReaderRepository.registerBookTakenByReader(
                readerBookDTO.getFirstname(),
                readerBookDTO.getSurname(),
                readerBookDTO.getDate(),
                readerBookDTO.getBookId()
        );
    }

    @Override
    public List<BookReaderDTO> findBookReaderEntitiesByBook_Id(Long id) {
        return bookReaderRepository.findBookReaderEntitiesByBook_Id(id).stream()
        .map(tmp ->BookReaderDTO.builder()
                .firstname(tmp.getFirstname())
                .surname(tmp.getSurname())
                .build())
                .collect(Collectors.toList());
    }


}
