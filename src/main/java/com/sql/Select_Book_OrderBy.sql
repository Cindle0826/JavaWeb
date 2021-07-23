-- SELECT
-- *
-- FROM Book b
-- ORDER BY b.PRICE

-- FETCH FIRST 2 ROWS ONLY; 要找前幾筆

-- 平均價格 =  總價/總數量

-- Select
-- b.name,
-- SUM(b.PRICE*b.AMOUNT)/SUM(b.AMOUNT) AS 平均價格,
-- SUM(b.amount) AS 數量,
-- SUM(b.price * b.amount) AS SUBTOTAL
-- From Book b
-- GROUP BY b.name;

-- SELECT
-- SUM(b.PRICE*b.AMOUNT) 全部總價
-- FROM BOOK b;

-- SELECT
-- *
-- FROM Book;

SELECT
b.name,
SUM(b.price * b.amount) AS SUBTOTAL,
-- 0.5 AS present,
(SUM(b.price * b.amount)) /(b.PRICE*b.AMOUNT) AS 百分比
FROM Book b
GROUP BY b."NAME"

