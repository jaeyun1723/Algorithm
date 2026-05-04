# SELECT concat('/home/grep/src/',board_id,'/', file_id, file_name,file_ext) as FILE_PATH
# FROM USED_GOODS_FILE
# WHERE board_id = (
# SELECT board_id
# FROM USED_GOODS_BOARD
# ORDER BY views desc
# limit 1)
# ORDER BY file_id desc

SELECT
     CONCAT('/home/grep/src/', B.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD B
LEFT JOIN USED_GOODS_FILE F
ON B.BOARD_ID = F.BOARD_ID
WHERE VIEWS in (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
ORDER BY F.FILE_ID DESC
;