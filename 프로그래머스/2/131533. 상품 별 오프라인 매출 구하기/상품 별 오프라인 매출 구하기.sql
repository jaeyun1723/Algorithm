SELECT product_code, price * sum(sales_amount) as sales
FROM product p natural join offline_sale s
GROUP BY product_code
ORDER BY sales DESC, product_code