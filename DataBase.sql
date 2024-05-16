CREATE DATABASE java_bar_app;

-- Utilisateur
CREATE TABLE User (
    id_user SERIAL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    mail VARCHAR(255),
    password VARCHAR(255)
);

-- Cocktail
CREATE TABLE Cocktail (
    id_cocktail SERIAL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    price_S DOUBLE PRECISION,
    price_M DOUBLE PRECISION,
    price_L DOUBLE PRECISION,
);

CREATE TABLE Category(
    id_category SERIAL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE Cocktail_Category (
    id_cocktail INT REFERENCES Cocktail(id_cocktail),
    id_category INT REFERENCES Category(id_category),
    PRIMARY KEY (id_cocktail, id_category)
);

-- Ingredient
CREATE TABLE Ingredient (
    id_ingredient SERIAL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

-- Cocktail_Ingredient
CREATE TABLE Cocktail_Ingredient (
    id_cocktail INT REFERENCES Cocktail(id_cocktail),
    id_ingredient INT REFERENCES Ingredient(id_ingredient),
    quantity INT,
    PRIMARY KEY (id_cocktail, id_ingredient)
);

-- Taille
CREATE TABLE Taille (
    id_taille SERIAL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

-- Commande
CREATE TABLE Commande (
    id_commande SERIAL PRIMARY KEY AUTO_INCREMENT,
    id_user INT REFERENCES User(id_user),
    created DATE,
    status_commande VARCHAR(255)
);

-- Commande_Cocktail
CREATE TABLE Commande_Cocktail (
    id_commande INT REFERENCES Commande(id_commande),
    id_cocktail INT REFERENCES Cocktail(id_cocktail),
    id_taille INT REFERENCES Taille(id_taille),
    quantity INT,
    status_cocktail VARCHAR(255)
);
-- Insertion de cocktails
INSERT INTO Cocktail (name, price_S, price_M, price_L)
VALUES ('Mojito', 8.99, 10.99, 12.99);

-- Insertion de la catégorie du cocktail
INSERT INTO Cocktail_Category (id_cocktail, id_category)
VALUES (1, 1); -- Le chiffre 1 représente l'ID du cocktail et l'ID de la catégorie "Cocktails classiques"

-- Insertion des ingrédients du cocktail (en supposant des quantités spécifiques)
INSERT INTO Cocktail_Ingredient (id_cocktail, id_ingredient, quantity)
VALUES (1, 1, 50), -- 50 ml de rhum
       (1, 2, 20), -- 20 ml de jus de citron vert
       (1, 3, 15), -- 15 ml de sucre de canne
       (1, 4, 100); -- 100 ml d'eau gazeuse