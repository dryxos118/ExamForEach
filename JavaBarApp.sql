CREATE DATABASE bar_app;

use bar_app;

CREATE TABLE if not exists User (
    id_user SERIAL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    mail VARCHAR(255),
    img varchar(255),
    password VARCHAR(255)
);

CREATE TABLE if not exists Cocktail (
    id_cocktail SERIAL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    price_S DOUBLE,
    price_M DOUBLE,
    price_L DOUBLE
);

CREATE TABLE if not exists Category(
    id_category SERIAL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE if not exists Cocktail_Category (
    id_cocktail INT REFERENCES Cocktail(id_cocktail),
    id_category INT REFERENCES Category(id_category),
    PRIMARY KEY (id_cocktail, id_category)
);

CREATE TABLE if not exists Ingredient (
    id_ingredient SERIAL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE if not exists Cocktail_Ingredient (
    id_cocktail INT REFERENCES Cocktail(id_cocktail),
    id_ingredient INT REFERENCES Ingredient(id_ingredient),
    PRIMARY KEY (id_cocktail, id_ingredient)
);

CREATE TABLE if not exists Taille (
    id_taille SERIAL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE if not exists Commande (
    id_commande SERIAL PRIMARY KEY AUTO_INCREMENT,
    created DATE,
    status_commande varchar(255)
);

CREATE TABLE if not exists Commande_Cocktail (
    id_commande_cocktail serial primary key auto_increment,
    id_commande INT REFERENCES Commande(id_commande),
    id_cocktail INT REFERENCES Cocktail(id_cocktail),
    id_taille INT REFERENCES Taille(id_taille),
    quantity INT,
    status_cocktail varchar(255)
);