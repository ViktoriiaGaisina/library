package com.example.library.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "book_reader")
public class BookReaderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_reader_id_pk")
    private Long id;
    private String firstname;
    private String surname;
    @Column(name = "registration_date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="book_id_fk")
    private BookEntity book;
}

