-- Create super user.

CREATE ROLE testuser LOGIN SUPERUSER PASSWORD 'testpassword';

-- Create table after check.

DROP TABLE IF EXISTS example;

CREATE TABLE example (
  id INT NOT NULL,
  name VARCHAR(30),
  oneonerelationfk INT,
  onemanyrelationfk INT,
  manyonerelationfk INT,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS oneonerelation;

CREATE TABLE oneonerelation (
  id INT NOT NULL,
  name VARCHAR(30),
  examplefk INT,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS onemanyrelation;

CREATE TABLE onemanyrelation (
  id INT NOT NULL,
  name VARCHAR(30),
  examplefk INT,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS manyonerelation;

CREATE TABLE manyonerelation (
  id INT NOT NULL,
  name VARCHAR(30),
  examplefk INT,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS manymanyrelation;

CREATE TABLE manymanyrelation (
  id INT NOT NULL,
  name VARCHAR(30),
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS E_M;

CREATE TABLE E_M (
  id INT,
  eId INT,
  mmId INT
);