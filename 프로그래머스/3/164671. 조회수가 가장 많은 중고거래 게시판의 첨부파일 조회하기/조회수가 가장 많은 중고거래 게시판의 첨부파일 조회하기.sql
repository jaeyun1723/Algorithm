-- 코드를 입력하세요
SELECT concat('/home/grep/src/',file.board_id,'/',file.file_id,file.file_name,file.file_ext) as 'FILE_PATH'
FROM used_goods_file as file JOIN
(SELECT *
FROM used_goods_board
ORDER BY views desc
LIMIT 1) as board
on file.board_id=board.board_id
ORDER BY file.file_id desc