CREATE DATABASE todo_app;

SET SQL_SAFE_UPDATES = 0;

CREATE TABLE person (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	gender ENUM("F", "M"),
	age TINYINT UNSIGNED
);

INSERT INTO person VALUES(NULL, "Botond", "Balogh", "M", 25);
INSERT INTO person VALUES(NULL, "Szabolcs", "Osztertag", "M", 26);
INSERT INTO person VALUES(NULL, "Zsofia", "Fabian", "F", 26);
INSERT INTO person VALUES(NULL, "Laszlo", "Molnar", "M", 30);

CREATE TABLE task (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    description VARCHAR(50) NOT NULL,
    difficulty ENUM ("E", "M", "H")
);

INSERT INTO task VALUES(NULL, "DEMO-01", "M");
INSERT INTO task VALUES(NULL, "Lightning talk", "E");
INSERT INTO task VALUES(NULL, "Foundation exam", "H");
INSERT INTO task VALUES(NULL, "Lightning talk", "M");

CREATE TABLE calendar (
    pID INT,
    FOREIGN KEY (pID) REFERENCES person (id),
    tID INT,
    FOREIGN KEY (pID) REFERENCES task (id),
    deadline DATE NOT NULL,
    done ENUM ("D", "U") DEFAULT "U"
);

INSERT INTO calendar VALUES(NULL,NULL, "2019-02-25", "D");
INSERT INTO calendar VALUES(1, 1, "2019-02-25", "D");
DELETE FROM calendar WHERE tID IS NULL;




    




