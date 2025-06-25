CREATE TABLE product (
     id INT NOT NULL AUTO_INCREMENT,
     name VARCHAR(500) NOT NULL,
     description VARCHAR(500),
     date_created DATE NOT NULL,
     price DOUBLE NOT NULL,
     flower_category VARCHAR(500) NOT NULL,
     product_category VARCHAR(500) NOT NULL,
     archived BOOLEAN NOT NULL,
     meaning VARCHAR(700),
     stock INT NOT NULL,

     PRIMARY KEY (id)
);
