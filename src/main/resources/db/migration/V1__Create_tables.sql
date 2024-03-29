CREATE TABLE Book (
    id int primary key not null,
    title varchar(100) not null,
    author_id int not null
);

CREATE TABLE Author  (
    id int primary key not null,
    name varchar(100) not null
);

CREATE SEQUENCE book_sequence start WITH 1 INCREMENT BY 1;
CREATE SEQUENCE author_sequence start WITH 1 INCREMENT BY 1;

ALTER TABLE Book ADD FOREIGN KEY (author_id) REFERENCES Author(id);

INSERT INTO Author(id, name) VALUES (1, 'Victor Hugo');
INSERT INTO Author(id, name) VALUES (2, 'Ernest Hemingway');

INSERT INTO Book(id, title, author_id) VALUES (1, 'Les Misérables', 1);