create table board
(
    id                bigint unsigned auto_increment comment 'ID' primary key,
    title             varchar(255)                               not null comment '제목',
    content           varchar(255)                               not null comment '내용',
    name              varchar(30)                                not null comment '이름',
    created_at        datetime         default CURRENT_TIMESTAMP null comment '작성일'
);