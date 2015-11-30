
DROP DATABASE IF EXISTS library;
CREATE DATABASE library;

USE library;

CREATE TABLE librarystuff
(
	firstName	VARCHAR(45),
    lastName	VARCHAR(45),
    emailAddress	VARCHAR(45)		PRIMARY KEY,
    bookTitle	VARCHAR(45),
    duedate		VARCHAR(45),
    overdue		VARCHAR(45)

);

