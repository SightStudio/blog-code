create table author
(
    id int(7) not null primary key AUTO_INCREMENT,
    first_name varchar(50) null,
    last_name varchar(50) not null,
    date_of_birth date null,
    year_of_birth int(7) null,
    distinguished int(1) null
);

create table book_store
(
    name varchar(400) not null,
    constraint name unique (name)
);

create table language
(
    id int(7) not null primary key AUTO_INCREMENT,
    cd char(2) not null,
    description varchar(50) null
);

create table book
(
    id int(7) not null primary key AUTO_INCREMENT,
    author_id int(7) not null,
    title varchar(400) not null,
    published_in int(7) not null,
    language_id int(7) not null
);

create table book_to_book_store
(
    name varchar(400) not null,
    book_id int not null,
    stock int null,
    primary key (name, book_id)
);