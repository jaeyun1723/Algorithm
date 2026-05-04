SELECT category, price as max_price, product_name
FROM (SELECT *, max(price) OVER(PARTITION BY category ORDER BY price DESC) as rn
      FROM food_product
      WHERE category IN ('과자','국','김치','식용유')) as cte
WHERE rn = price    
ORDER BY price DESC

# SELECT category, price as max_price, product_name
# FROM food_product
# WHERE (category, price) IN (SELECT category, max(price)
#                             FROM food_product
#                             WHERE category IN ('과자','국','김치','식용유')
#                             GROUP BY category)
# ORDER BY price DESC