DELETE FROM products;

ALTER SEQUENCE products_id_seq RESTART WITH 1;

INSERT INTO products (name, price, color, capacity, display, description)
VALUES ('iPhone 7', 700, 0, 64, '4,7 inch', NULL);
INSERT INTO products (name, price, color, capacity, display, description)
VALUES ('iPhone 7', 700, 1, 128, '4,7 inch', NULL);
INSERT INTO products (name, price, color, capacity, display, description)
VALUES ('iPhone 7', 700, 2, 256, '4,7 inch', NULL);
INSERT INTO products (name, price, color, capacity, display, description)
VALUES ('iPhone 7 Plus', 800, 0, 256, '5,5 inch', NULL);
INSERT INTO products (name, price, color, capacity, display, description)
VALUES ('iPhone 7 Plus', 800, 2, 64, '5,5 inch', NULL);
INSERT INTO products (name, price, color, capacity, display, description)
VALUES ('iPhone 7 Plus', 800, 1, 128, '5,5 inch', NULL);