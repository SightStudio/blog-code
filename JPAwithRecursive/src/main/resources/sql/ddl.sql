create table company
(
    board_seq bigint auto_increment
        primary key,
    created_at datetime(6) null,
    updated_at datetime(6) null,
    name varchar(255) null
);

create table department
(
    dept_seq bigint auto_increment
        primary key,
    created_at datetime(6) null,
    updated_at datetime(6) null,
    depth int not null,
    name varchar(255) null,
    company_seq bigint null,
    parent_dept_seq bigint null,

    constraint FK27x8o5lawxio5jovbp7qdabm4
        foreign key (company_seq) references company (board_seq),

    constraint FKgaog9q38ysvmm8rfhgm7qcndy
        foreign key (parent_dept_seq) references department (dept_seq)
);

