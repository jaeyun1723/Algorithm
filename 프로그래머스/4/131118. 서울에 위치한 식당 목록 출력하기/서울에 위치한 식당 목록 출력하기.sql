SELECT i.rest_id, rest_name, food_type, favorites, address, score
FROM rest_info as i JOIN (SELECT rest_id, round(avg(review_score),2) as score
                            FROM rest_review
                            GROUP BY rest_id) as r ON i.rest_id=r.rest_id
WHERE left(address,2)='서울'
ORDER BY score DESC, favorites DESC