-- 코드를 입력하세요
SELECT a.food_type, a.rest_id, a.rest_name, a.favorites
FROM rest_info as a
JOIN (SELECT food_type, max(favorites) as most
        FROM rest_info
        GROUP BY food_type) as b
ON a.food_type=b.food_type
WHERE a.favorites=b.most
ORDER BY food_type DESC