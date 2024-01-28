package com.example.library.service.impl;

import com.example.library.dao.BookReaderDao;
import com.example.library.dto.ReaderBookDTO;
import com.example.library.dto.bookreader.BookReaderDTO;
import com.example.library.repository.BookReaderRepository;
import com.example.library.service.BookReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookReaderServiceImpl implements BookReaderService {
    private final BookReaderRepository bookReaderRepository;
    private final BookReaderDao readerDao;

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
    public void saveReader(ReaderBookDTO readerBookDTO) {
        if(readerBookDTO.getFirstname().isEmpty()) {
            throw new IllegalArgumentException("Фамилия обязательна к заполнению");
        }
        readerDao.saveReader(readerBookDTO);
    }


    @Override
    public List<BookReaderDTO> findBookReaderEntitiesByBook_Id(Long id) {
        return bookReaderRepository.findBookReaderEntitiesByBook_Id(id).stream()
                .map(tmp -> BookReaderDTO.builder()
                        .firstname(tmp.getFirstname())
                        .surname(tmp.getSurname())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void updateBookReader(ReaderBookDTO readerBookDTO) {
        readerDao.update(readerBookDTO);
    }

    @Override
    public void deleteBookReader(Long id) {
        readerDao.deleteBookReader(id);
    }
}
