CREATE DATABASE hundred_acre_wood;

SHOW DATABASES;

SET SQL_SAFE_UPDATES = 0;

USE hundred_acre_wood;

CREATE TABLE inhabitants (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(30) NOT NULL,
    gender ENUM("F", "M"),
    age TINYINT UNSIGNED
);

SHOW TABLES;

INSERT INTO inhabitants VALUES(NULL, "Micimacko", "M", 6);
INSERT INTO inhabitants VALUES(NULL, "Malacka", "F", 4);
INSERT INTO inhabitants VALUES(NULL, "Tigris", "M", 0);
INSERT INTO inhabitants (age, name, gender) VALUES (80, "Bagoly", "M");
INSERT INTO inhabitants VALUES(NULL, "Fules", NULL, 30);

SELECT * FROM inhabitants;

DELETE FROM inhabitants WHERE gender IS NULL;

UPDATE inhabitants
	SET age = 5
    WHERE name = 'Tigris';
    
#deleting record from table
DELETE FROM inhabitants WHERE gender IS NULL;

#override column name
ALTER TABLE inhabitants CHANGE age inhabitant_age TINYINT UNSIGNED;

#selecting inhabitants by age between 4 and 6
SELECT * FROM inhabitants 
	WHERE inhabitant_age BETWEEN 4 AND 6;

#selecting all males
SELECT name, inhabitant_age FROM inhabitants
	WHERE gender = 'M';

#creating new tables
CREATE TABLE meal (
	id INT AUTO_INCREMENT,
    name VARCHAR(20),
    cost INT NULL,
    inhabitant_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (inhabitant_id) REFERENCES inhabitants (id)
);

#override table name
RENAME TABLE meal to meals;

INSERT INTO meals VALUES (NULL, "mez", NULL, 1);
INSERT INTO meals VALUES (NULL, "mez", 100, 1);
INSERT INTO meals VALUES (NULL, "repa", 10, 6);

#selecting all records from meals
SELECT * FROM meals;

#joining the 2 tables
SELECT * FROM inhabitants, meals
	WHERE inhabitants.id = meals.inhabitant_id;

#select all the inhabitants who ate "repa"
SELECT inhabitants.name FROM inhabitants, meals
	WHERE meals.name = "repa" AND
    inhabitants.id = meals.inhabitant_id;

#selecting inhabitants who ate "mez"
SELECT * FROM inhabitants JOIN meals
	ON inhabitants.id = meals.inhabitant_id
    WHERE meals.name = "mez";

#get the average cost
SELECT FLOOR(AVG(cost)) AS 'average cost'
	FROM meals;

#put tax on all meals
SELECT id, name, cost + 50 FROM meals
	WHERE cost  IS NOT NULL;

#count all the inhabitants
SELECT COUNT(id) FROM inhabitants;

#list all the meals where the name started with the letter 'm'
SELECT * FROM meals
	WHERE name LIKE 'm%';

INSERT INTO meals VALUES (NULL, "hagyma", 2, 1);

#list how many meals the inhabitant eaten
SELECT inhabitants.name, COUNT(meals.name) AS "meals eaten"
	FROM inhabitants
    JOIN meals
    ON inhabitants.id = meals.inhabitant_id
    GROUP BY meals.inhabitant_id
    HAVING COUNT(meals.name) >=2;

INSERT INTO meals (name, cost, inhabitant_id) VALUES
	("porkolt", 20, 2),
    ("ananasz", 45, 3),
    ("lecso", 30, 4),
    ("csulok pekne modra", 60, 6),
	("mez", 1000, 1);

SELECT * FROM inhabitants
	ORDER BY inhabitant_age DESC, name ASC
	LIMIT 1 OFFSET 1;

#get second oldest inhabitant
SELECT CONCAT(name, " is ", inhabitant_age, " years old") AS "second oldest inhabitant in the hundred acre wood"
	FROM inhabitants
	WHERE inhabitant_age = (
		SELECT inhabitant_age FROM inhabitants
			ORDER BY inhabitant_age DESC, name ASC
			LIMIT 1 OFFSET 1
	);

#get "Micimacko"s most expensive meals average
SELECT inhabitants.name, meals.name, AVG(meals.cost) as average_cost
	FROM inhabitants, meals
    WHERE inhabitants.id = meals.inhabitant_id
	AND inhabitants.name = 'Micimacko'
    GROUP BY inhabitants.name, meals.name
    ORDER BY average_cost DESC
    LIMIT 1;
    
