-- 增�?��??? amount ?��??? int 欄�??
-- ALTER TABLE  Book ADD COLUMN amount int DEFAULT 0; 

SELECT
b.name,
AVG(b.price),
SUM(b.price *b.amount) AS SUBTOTAL
FROM BOOK b
GROUP BY b."NAME"
-- ORDER BY b.amount DESC
