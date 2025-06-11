SELECT a.rest_id, rest_name, food_type, favorites, address, round(avg(review_score),2) as score
FROM rest_info as a JOIN rest_review as b ON a.rest_id=b.rest_id
WHERE address like '서울%'
GROUP BY a.rest_id
ORDER BY score DESC, favorites DESC