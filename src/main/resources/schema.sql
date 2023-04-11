CREATE TABLE category (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(45) NOT NULL
);

CREATE TABLE operation (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  category_id BIGINT NOT NULL,
  type VARCHAR(45) NOT NULL,
  amount DECIMAL(6,2) NOT NULL,
  created DATETIME NULL,
  description VARCHAR(45) NULL
);

ALTER TABLE operation ADD CONSTRAINT operation_category_id FOREIGN KEY (category_id) REFERENCES category(id);