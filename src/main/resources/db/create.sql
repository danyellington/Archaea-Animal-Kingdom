SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS archaeaDomains (
 id int PRIMARY KEY auto_increment,
 domainName VARCHAR
 );


CREATE TABLE IF NOT EXISTS archaeaPhyla (
 id int PRIMARY KEY auto_increment,
 phylumName VARCHAR
 );


CREATE TABLE IF NOT EXISTS archaeaClasses (
 id int PRIMARY KEY auto_increment,
 className VARCHAR
 );


CREATE TABLE IF NOT EXISTS archaeaOrders (
 id int PRIMARY KEY auto_increment,
 orderName VARCHAR
 );


CREATE TABLE IF NOT EXISTS archaeaFamilies (
 id int PRIMARY KEY auto_increment,
 familyName VARCHAR
 );


CREATE TABLE IF NOT EXISTS archaeaGenera (
 id int PRIMARY KEY auto_increment,
 genusName VARCHAR
 );


CREATE TABLE IF NOT EXISTS archaeaSpecies (
 id int PRIMARY KEY auto_increment,
 speciesName VARCHAR
 );