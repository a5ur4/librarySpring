CREATE DATABASE IF NOT EXISTS library;
USE library;

CREATE TABLE admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    bookName VARCHAR(255) NOT NULL DEFAULT 'No book',
    daysWithBook INT NOT NULL DEFAULT 0
);

CREATE TABLE book (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL UNIQUE,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    isUsing BOOLEAN NOT NULL DEFAULT FALSE,
    bookOwnerId INT NOT NULL DEFAULT 0
);

# Test session

select * from user;
select * from admin;
select * from book;

drop table admin;
drop table user;
drop table book;
drop database library;

INSERT INTO admin (name, password) 
    VALUES 
    ('AdminTest', '1234'), 
    ('AdminTwo', 'abcd'), 
    ('AdminThree', 'admin123');

INSERT INTO user (name, password, email) 
    VALUES 
    ('UserTest', '1234', 'teste@email.com'), 
    ('Alice', 'password', 'alice@example.com'),
    ('Bob', 'bobpass', 'bob@example.com'),
    ('Charlie', 'charliepass', 'charlie@example.com'),
    ('David', 'davidpass', 'david@example.com');

INSERT INTO book (title, author, genre, description) 
VALUES 
    ('Harry Potter', 'JK Rowling', 'Fantasy', 'A young wizard embarks on a magical journey.'),
    ('Berserk', 'Kentaro Miura', 'Dark Fantasy', 'A lone mercenary battles dark forces in a brutal world.'),
    ('The Book of Five Rings', 'Musashi Miyamoto', 'Philosophy', 'A samurai shares his insights on strategy and combat.'),
    ('1984', 'George Orwell', 'Dystopian', 'A totalitarian regime uses surveillance to control society.'),
    ('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 'A lawyer defends an innocent black man in the racially divided South.'),
    ('The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', 'A mysterious millionaire chases the American Dream in the 1920s.'),
    ('One Hundred Years of Solitude', 'Gabriel Garcia Marquez', 'Magical Realism', 'The epic story of the Buendía family in the town of Macondo.'),
    ('Moby Dick', 'Herman Melville', 'Adventure', 'A captain obsessively hunts a giant white whale.'),
    ('War and Peace', 'Leo Tolstoy', 'Historical', 'A sweeping narrative of Russian society during the Napoleonic Wars.'),
    ('Pride and Prejudice', 'Jane Austen', 'Romance', 'A witty examination of manners and marriage in early 19th-century England.');
