create table if not exists app_user (
    user_seq  bigint auto_increment primary key,
    user_id   varchar(255) not null,
    user_name varchar(255) not null,
    constraint UK_qjho89hmbuv32f9a8tbocpr0i
    unique (user_id)
);

create table if not exists board_type (
    board_type_seq bigint auto_increment primary key,
    code           varchar(255) not null,
    code_name      varchar(255) not null
);

create table if not exists board (
    board_seq      bigint auto_increment primary key,
    reg_date       datetime(6)  null,
    content        varchar(255) not null,
    title          varchar(255) not null,
    board_type_seq bigint       not null,
    user_seq       bigint       not null,
    constraint FK1u7ywt94islad666xmdi4juxb
    foreign key (user_seq) references app_user (user_seq),
    constraint FK219u599g2m5uoup2vcvjiptka
    foreign key (board_type_seq) references board_type (board_type_seq)
);

