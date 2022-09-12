SELECT count(*) from app_user;
SELECT count(*) from board_type;
SELECT count(*) from board;


# EXPLAIN ANALYZE
EXPLAIN
SELECT
    b.board_seq,
    b.board_type_seq,
    b.user_seq,
    (SELECT code_name from board_type bt where bt.board_type_seq = b.board_type_seq) as type_nm,
    (SELECT user_name from app_user u where u.user_seq = b.user_seq) as user_nm,
    b.title,
    b.content,
    b.reg_date
FROM board b
WHERE
    b.reg_date BETWEEN '2000-01-01' AND '2022-02-15'
LIMIT 30
    OFFSET 21000;

EXPLAIN ANALYZE



SELECT
    b.board_seq,
    b.board_type_seq,
    b.user_seq,
    bt.code_name,
    au.user_name,
    b.title,
    b.content,
    b.reg_date
FROM board b
LEFT JOIN board_type bt
    on b.board_type_seq = bt.board_type_seq
LEFT JOIN app_user au
    on b.user_seq = au.user_seq
WHERE
    b.reg_date BETWEEN '2000-01-01' AND '2022-02-15'
LIMIT 30
OFFSET 2100;

# EXPLAIN ANALYZE
EXPLAIN
SELECT
    b.board_seq,
    b.board_type_seq,
    b.user_seq,
    (SELECT code_name from board_type bt where bt.board_type_seq = b.board_type_seq) as type_nm,
    (SELECT user_name from app_user u where u.user_seq = b.user_seq) as user_nm,
    b.title,
    b.content,
    b.reg_date
FROM board b
WHERE
#     b.reg_date BETWEEN '2022-01-01' AND '2022-02-15'
b.content LIKE '%abc%'
# ORDER BY b.reg_date DESC
LIMIT 10
    OFFSET 60;

EXPLAIN ANALYZE
SELECT SQL_NO_CACHE
    b.board_seq,
    b.board_type_seq,
    b.user_seq,
    t.code_name,
    u2.user_name,
    b.title,
    b.content,
    b.reg_date
FROM board b
         LEFT JOIN board_type t
                   on b.board_type_seq = t.board_type_seq
         LEFT JOIN app_user u2
                   on b.user_seq = u2.user_seq
WHERE
#     b.reg_date BETWEEN '2022-01-01' AND '2022-02-15' AND
b.content LIKE '%찾으%'
ORDER BY b.reg_date DESC
LIMIT 1
OFFSET 2;


show indexes from board;
ALTER TABLE board alter index board_reg_date_index invisible;
ALTER TABLE board alter index board_reg_date_index visible;

ALTER TABLE board alter index board_user_seq_index invisible;
ALTER TABLE board alter index board_user_seq_index visible;

ALTER TABLE board alter index board_board_type_seq_index invisible;
ALTER TABLE board alter index board_board_type_seq_index visible;

SELECT * FROM board where board_seq = 1;