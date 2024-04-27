-- 코드를 입력하세요
SELECT  MEMBER_ID,MEMBER_NAME,gender, date_format(date_of_birth,"%Y-%m-%d") DATE_OF_BIRTH
FROM member_profile
WHERE TLNO is not null AND gender='W'AND Month(DATE_OF_BIRTH)=3
ORDER BY member_id ASC;