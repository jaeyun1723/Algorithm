SELECT concat('/home/grep/src/',board_id,'/', file_id, file_name,file_ext) as FILE_PATH
FROM USED_GOODS_FILE
WHERE board_id = (
SELECT board_id
FROM USED_GOODS_BOARD
ORDER BY views desc
limit 1)
ORDER BY file_id desc
