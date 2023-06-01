INSERT INTO category (name) VALUES ('Salary'),
('Groceries'),
('Restaurant'),
('Rent'),
('Fuel'),
('Subscription'),
('Clothes'),
('Public transport');

INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (1, 1, 'INCOME', 5000.00, '2023-01-01', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (1, 1, 'INCOME', 5000.00, '2023-02-01', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (1, 1, 'INCOME', 5000.00, '2023-03-01', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -123.56, '2023-01-03', 'Lidl');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -181.64, '2023-01-12', 'Tesco');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -56.68, '2023-01-17', 'Lidl');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -24.52, '2023-01-24', 'Spar');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -134.57, '2023-01-04', 'Lidl');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -203.19, '2023-02-11', 'Tesco');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -83.56, '2023-02-19', 'Lidl');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -74.67, '2023-02-28', 'Lidl');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -87.60, '2023-02-06', 'Lidl');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -42.35, '2023-02-14', 'Spar');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (2, 1, 'EXPENSE', -154.06, '2023-02-23', 'Lidl');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (3, 1, 'EXPENSE', -39.99, '2023-01-18', 'Surfburger');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (3, 1, 'EXPENSE', -45.00, '2023-02-14', 'Pizza');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (4, 1, 'EXPENSE', -2000.00, '2023-01-03', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (4, 1, 'EXPENSE', -2000.00, '2023-02-02', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (4, 1, 'EXPENSE', -2000.00, '2023-03-06', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (5, 1, 'EXPENSE', -400.00, '2023-01-02', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (5, 1, 'EXPENSE', -355.00, '2023-03-05', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (6, 1, 'EXPENSE', -60.00, '2023-01-18', 'Netflix');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (6, 1, 'EXPENSE', -60.00, '2023-02-18', 'Netflix');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (6, 1, 'EXPENSE', -60.00, '2023-03-18', 'Netflix');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (7, 1, 'EXPENSE', -159.00, '2023-01-12', 'Adidas');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (7, 1, 'EXPENSE', -359.00, '2023-03-02', 'Nike');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (8, 1, 'EXPENSE', -80.00, '2023-01-09', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (8, 1, 'EXPENSE', -80.00, '2023-02-09', '');
INSERT INTO operation (category_id, user_id, type, amount, created, description) VALUES (8, 1, 'EXPENSE', -80.00, '2023-03-09', '');

INSERT INTO api_user (firstname, lastname, email, password, role) VALUES ('Michał', 'Cabański', 'michalcabanski@wp.pl', '$2a$12$cBPNq4q7M0ICghPWhKmLYOlhKpOZ2YrY8I3H9OJkUUY84hqrnYBIe' ,'USER');