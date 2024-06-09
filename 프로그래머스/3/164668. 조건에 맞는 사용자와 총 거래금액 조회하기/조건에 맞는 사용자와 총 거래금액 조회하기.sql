SELECT user_id as USER_ID,nickname as NICKNAME,sum(price) as TOTAL_SALES
FROM used_goods_user as a inner join used_goods_board as b on a.user_id=b.writer_id
WHERE STATUS='DONE'
GROUP BY user_id
HAVING total_sales>=700000
ORDER BY total_sales
