create table if not exists book_reader(
    book_reader_id_pk serial primary key,
    name varchar,
    book_id_fk int references book(book_id_pk)
)