SELECT user_id, nickname, concat(city,' ', street_address1,' ', street_address2) as 전체주소,
       concat(left(tlno,3),'-',substr(tlno,4,4),'-',right(tlno,4)) as 전화번호
FROM used_goods_user as a JOIN
(SELECT writer_id
FROM used_goods_board
GROUP BY writer_id
HAVING count(writer_id)>=3) as b
ON a.user_id=b.writer_id
ORDER BY user_id DESC
