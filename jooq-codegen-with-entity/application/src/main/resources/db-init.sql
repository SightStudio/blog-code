create table if not exists app_user
(
    user_seq  int auto_increment
        primary key,
    user_id   varchar(10)  not null,
    user_name varchar(100) not null,
    constraint user_user_id_uindex
        unique (user_id)
);

create table if not exists board
(
    board_seq      bigint auto_increment
        primary key,
    title          varchar(100) not null,
    content        mediumtext   not null,
    board_type_seq bigint       not null,
    user_seq       bigint       not null,
    reg_date       datetime     null
);

create index board_board_type_seq_index
    on board (board_type_seq);

create index board_reg_date_index
    on board (reg_date);

create index board_user_seq_index
    on board (user_seq);

create table if not exists board_type
(
    board_type_seq bigint auto_increment
        primary key,
    code           varchar(30) null,
    code_name      varchar(30) null,
    constraint board_type_code_uindex
        unique (code)
);
