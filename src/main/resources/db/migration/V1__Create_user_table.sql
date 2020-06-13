create table user
(
    id                 int auto_increment
        primary key,
    username           varchar(20)             not null,
    encrypted_password varchar(100)            not null,
    avatar             varchar(100) default '' null,
    created_at         datetime                null,
    updated_at        datetime                null
);

INSERT INTO user (id, username, encrypted_password, avatar, created_at, updated_at) VALUES (1, 'aaa', '$2a$10$ObcALVI496h0a9MU.lOjduxUaG0//9aFyLeNs2LOVxcj/iHt.xRga', '', '2020-06-09 02:33:45', '2020-06-09 02:33:45');
INSERT INTO user (id, username, encrypted_password, avatar, created_at, updated_at) VALUES (5, 'bbb', '$2a$10$a1gR2H3462C5/Pq4u45aMO4i0iyWHY7zrZXkSGTpglxjSaCQb5pW6', '', '2020-06-09 03:01:57', '2020-06-09 03:01:57');