USE  adlister_db;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
id INT UNSIGNED NOT NULL AUTO_INCREMENT,
username VARCHAR(50),
email VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);


DROP TABLE IF EXISTS ads;

CREATE TABLE ads (
id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(100) NOT NULL,
description TEXT,
date_created DATETIME,
user_id INT UNSIGNED NOT NULL,
FOREIGN KEY (id) REFERENCES users(id)
);