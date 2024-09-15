-- 코드를 입력하세요
SELECT left(product_code,2) as category, count(*) as products
FROM product
GROUP BY category
ORDER BY category
