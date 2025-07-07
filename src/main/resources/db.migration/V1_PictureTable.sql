CREATE TABLE picture (
   id INT NOT NULL AUTO_INCREMENT,
   picture BYTEA NOT NULL,
   product_id BIGINT NOT NULL,
   CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE

       PRIMARY KEY (id)
);