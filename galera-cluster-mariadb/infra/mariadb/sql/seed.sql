insert into author (first_name, last_name, date_of_birth, year_of_birth, distinguished)
values  ('George', 'Orwell', '1903-06-26', 1903, null),
        ('Paulo', 'Coelho', '1947-08-24', 1947, null);

insert into language (cd, description)
values  ('en', 'English'),
        ('de', 'Deutsch'),
        ('fr', 'Français'),
        ('pt', 'Português');

insert into book (author_id, title, published_in, language_id)
values  (1, '1984', 1948, 1),
        (1, 'Animal Farm', 1945, 1),
        (2, 'O Alquimista', 1988, 4),
        (2, 'Brida', 1990, 2);


insert into book_store (name)
values  ('Buchhandlung im Volkshaus'),
        ('Ex Libris'),
        ('Orell Füssli');

insert into book_to_book_store (name, book_id, stock)
values  ('Buchhandlung im Volkshaus', 3, 1),
        ('Ex Libris', 1, 1),
        ('Ex Libris', 3, 2),
        ('Orell Füssli', 1, 10),
        ('Orell Füssli', 2, 10),
        ('Orell Füssli', 3, 10);