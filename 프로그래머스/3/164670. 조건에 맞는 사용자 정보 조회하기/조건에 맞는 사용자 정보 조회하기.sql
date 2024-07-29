-- 코드를 입력하세요
SELECT user_id as USER_ID, nickname as NICKNAME, concat(city,' ',street_address1,' ',street_address2) as 전체주소, concat(left(tlno,3),'-',substr(tlno,4,4),'-',right(tlno,4)) as 전화번호
FROM (SELECT writer_id
        FROM used_goods_board
        GROUP BY writer_id
        HAVING count(writer_id)>=3) as a
INNER JOIN used_goods_user on a.writer_id=user_id
ORDER BY user_id DESC;
