
insert into jooq.author (id, first_name, last_name, date_of_birth, year_of_birth, distinguished)
values  (1, 'George', 'Orwell', '1903-06-26', 1903, null),
        (2, 'Paulo', 'Coelho', '1947-08-24', 1947, null);

insert into jooq.language (id, cd, description)
values  (1, 'en', 'English'),
        (2, 'de', 'Deutsch'),
        (3, 'fr', 'Français'),
        (4, 'pt', 'Português');

insert into jooq.book (id, author_id, title, published_in, language_id)
values  (1, 1, '1984', 1948, 1),
        (2, 1, 'Animal Farm', 1945, 1),
        (3, 2, 'O Alquimista', 1988, 4),
        (4, 2, 'Brida', 1990, 2);


insert into jooq.book_store (name)
values  ('Buchhandlung im Volkshaus'),
        ('Ex Libris'),
        ('Orell Füssli');

insert into jooq.book_to_book_store (name, book_id, stock)
values  ('Buchhandlung im Volkshaus', 3, 1),
        ('Ex Libris', 1, 1),
        ('Ex Libris', 3, 2),
        ('Orell Füssli', 1, 10),
        ('Orell Füssli', 2, 10),
        ('Orell Füssli', 3, 10);