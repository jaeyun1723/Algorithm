SELECT user_id, product_id
FROM ONLINE_SALE 
GROUP BY user_id, product_id
HAVING count((concat(user_id,product_id)))>1
ORDER BY user_id, product_id DESC