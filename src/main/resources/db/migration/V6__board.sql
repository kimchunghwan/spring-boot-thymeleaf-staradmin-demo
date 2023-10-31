create table board
(
    id                int auto_increment comment 'ID' primary key,
    title             varchar(255)                               not null comment '제목',
    content           varchar(255)                               not null comment '내용',
    name              varchar(30)                                not null comment '작성자',
    view_cnt          int(11)                                    not null comment '조회 수',
    created_at        datetime         default CURRENT_TIMESTAMP null comment '작성일',
    updated_at        datetime         default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '수정일'
);