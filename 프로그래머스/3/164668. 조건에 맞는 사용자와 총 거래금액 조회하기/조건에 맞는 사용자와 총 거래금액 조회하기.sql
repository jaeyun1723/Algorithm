SELECT user_id, nickname, sum(price) as total_sales
FROM used_goods_board a JOIN used_goods_user b ON a.writer_id = b.user_id
WHERE status = 'DONE'
GROUP BY writer_id
HAVING sum(price) >= 700000
ORDER BY total_sales
