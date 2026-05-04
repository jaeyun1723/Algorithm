SELECT year(sales_date) as YEAR, month(sales_date) as MONTH, gender, count( distinct b.user_id) as USERS
FROM USER_INFO a JOIN ONLINE_SALE b ON a.user_id = b.user_id
WHERE GENDER IS NOT NULL
GROUP BY year(sales_date), month(sales_date), gender
ORDER BY YEAR, MONTH, gender