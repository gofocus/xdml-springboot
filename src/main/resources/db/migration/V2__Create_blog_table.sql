create table blog
(
    id          int primary key auto_increment,
    title       varchar(20) not null,
    description text,
    content     text,
    user_id     int,
    created_at  datetime,
    updated_at datetime
);


insert into blog (title, description, user_id, created_at, updated_at, content)
values ('title1', 'description1', 1, now(), now(), 'content...');insert into blog (title, description, user_id, created_at, updated_at, content)
values ('title2', 'description2', 1, now(), now(), 'content...');insert into blog (title, description, user_id, created_at, updated_at, content)
values ('title3', 'description3', 1, now(), now(), 'content...');insert into blog (title, description, user_id, created_at, updated_at, content)
values ('title4', 'description4', 1, now(), now(), 'content...');insert into blog (title, description, user_id, created_at, updated_at, content)
values ('title5', 'description5', 1, now(), now(), 'content...');insert into blog (title, description, user_id, created_at, updated_at, content)
values ('title6', 'description6', 1, now(), now(), 'content...');
