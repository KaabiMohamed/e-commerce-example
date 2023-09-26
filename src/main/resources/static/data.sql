-- Insert sample data into Currency table
INSERT INTO currency (currency, symbol)
VALUES
('EUR', '€');


-- Insert sample data into TaxRate table
INSERT INTO tax_rate (id, tax_rate)
VALUES
(1, 0),     -- 0%
(2, 10),  -- 10%
(3, 5);  -- 5%

-- Insert sample data into TaxGroup table
INSERT INTO tax_group (id, name, TAX_RATE_ID, TAX_CATEGORY, ADDITIONAL_TAX_ID)
VALUES
(1, 'Basic Tax', 2, 'BASIC', NULL),
(2, 'Imported product Tax', 2, 'IMPORT', 3),
(3, 'Imported product with exemption TAX', 1, 'IMPORT', 3),
(4, 'Tax Exemption', 1, 'EXEMPTION', NULL);

-- Insert sample data into Category table
INSERT INTO category (id, name)
VALUES
(1, 'Books'),
(2, 'Food'),
(3, 'Medical Products'),
(4, 'Electronics'),
(5, 'Perfumes');


-- Insert sample data into Product table
INSERT INTO Product (id, name, TAX_ID, CATEGORY_ID, IS_IMPORTED)
VALUES
(1, 'book', 4, 1, 0),                    -- 1 book at 12.49 (EXEMPTION category)
(2, 'music CD', 1, 4, 0),                -- 1 music CD at 14.99 (BASIC category)
(3, 'chocolate bar', 4, 2, 0),           -- 1 chocolate bar at 0.85 (EXEMPTION category)
(4, 'imported box of chocolates', 3, 2, 1),  -- 1 imported box of chocolates at 10.00 (IMPORT category)
(5, 'imported bottle of perfume', 2, 5, 1),  -- 1 imported bottle of perfume at 47.50 (IMPORT category)
(6, 'imported bottle of perfume', 2, 5, 1),  -- 1 imported bottle of perfume at 27.99 (IMPORT category)
(7, 'bottle of perfume', 1, 5, 0),       -- 1 bottle of perfume at 18.99 (BASIC category)
(8, 'packet of headache pills', 4, 3, 0), -- 1 packet of headache pills at 9.75 (EXEMPTION category)
(9, 'box of imported chocolates', 3, 2, 1); -- 1 box of imported chocolates at 11.25 (IMPORT category)

-- Insert sample data into PriceRow table
INSERT INTO PRICE_ROW (id, price, CURRENCY_ID, PRODUCT_ID)
VALUES
(1, 12.49, 'EUR', 1),   -- Price for the book in EUR
(2, 14.99, 'EUR', 2),   -- Price for the music CD in EUR
(3, 0.85, 'EUR', 3),    -- Price for the chocolate bar in EUR
(4, 10.00, 'EUR', 4),   -- Price for the imported box of chocolates in EUR
(5, 47.50, 'EUR', 5),   -- Price for the imported bottle of perfume in EUR
(6, 27.99, 'EUR', 6),   -- Price for the imported bottle of perfume in EUR
(7, 18.99, 'EUR', 7),   -- Price for the bottle of perfume in EUR
(8, 9.75, 'EUR', 8),    -- Price for the packet of headache pills in EUR
(9, 11.25, 'EUR', 9);   -- Price for the box of imported chocolates in EUR
