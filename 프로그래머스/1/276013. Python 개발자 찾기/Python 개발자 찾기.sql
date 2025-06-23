SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE skill_1 IN ('Python') or skill_2 IN ('Python') or skill_3 IN ('Python')
ORDER BY ID