SELECT title, a.board_id, reply_id, b.writer_id, b.contents, DATE_FORMAT(b.created_date, '%Y-%m-%d') as created_date
FROM used_goods_board as a JOIN used_goods_reply as b ON a.board_id=b.board_id
WHERE DATE_FORMAT(a.created_date,'%Y-%m')='2022-10'
ORDER BY b.created_date, title