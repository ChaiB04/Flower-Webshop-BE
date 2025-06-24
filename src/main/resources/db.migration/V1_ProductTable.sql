CREATE TABLE product (
     id INT NOT NULL AUTO_INCREMENT,
     name VARCHAR(500) NOT NULL,
     description VARCHAR(500),
     date_created DATE NOT NULL,
     price DOUBLE NOT NULL,
     category VARCHAR(500) NOT NULL,
     active BOOLEAN NOT NULL,

     PRIMARY KEY (id)
);
