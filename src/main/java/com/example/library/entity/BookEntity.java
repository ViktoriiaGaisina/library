package com.example.library.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id_pk")
    private Long id;
    private String name;
    private String genre;
    private String nameAuthor;

    @OneToMany(mappedBy = "book")
    private List<BookReaderEntity> readerEntityList;

}
