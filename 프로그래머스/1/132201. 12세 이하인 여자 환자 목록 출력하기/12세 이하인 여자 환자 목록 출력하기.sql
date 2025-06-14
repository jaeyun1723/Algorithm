-- 코드를 입력하세요
SELECT PT_NAME,PT_NO,GEND_CD,AGE,IFNULL(TLNO,"NONE") as tlno
FROM patient
WHERE age<=12 and gend_cd='W'
ORDER BY age desc, pt_name