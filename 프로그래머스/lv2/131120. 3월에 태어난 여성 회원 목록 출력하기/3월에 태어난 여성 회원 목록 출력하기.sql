SELECT member_id, member_name, gender, date_format(date_of_birth,'%Y-%m-%d') as date_of_birth
FROM member_profile
WHERE month(date_of_birth)=3 AND gender='W' AND tlno IS NOT NULL
ORDER BY member_id