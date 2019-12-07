CREATE DATABASE one_to_many_lesson ENCODING 'UTF-8';


CREATE TABLE IF NOT EXISTS cars (
  id   SERIAL PRIMARY KEY,
  cost INTEGER,
  mark VARCHAR(25)
);

INSERT INTO cars (mark, cost) VALUES ('ford', 100000);
INSERT INTO cars (mark, cost) VALUES ('ford', 10984673);
INSERT INTO cars (mark, cost) VALUES ('mazda', 10984673);


CREATE TABLE IF NOT EXISTS engines (
  id       SERIAL PRIMARY KEY,
  name     VARCHAR(25) NOT NULL,
  power    INTEGER     NOT NULL,
  car_mark VARCHAR(25)
);

INSERT INTO engines (name, power, car_mark) VALUES ('super-engine', 10000, 'ford');