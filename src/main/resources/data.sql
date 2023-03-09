insert into author (fullname)
values ('John Bunyan'),
       ('Gianni Rodari'),
       ('Daniel Defoe');
insert into genre (name)
values ('History'),
       ('Classic'),
       ('Fantasy');
insert into book (title, author_id, genre_id)
values ('The Pilgrim’s Progress', 1, 1),
       ('Robinson Crusoe', 2, 2),
       ('The Holy War', 1, 1);
