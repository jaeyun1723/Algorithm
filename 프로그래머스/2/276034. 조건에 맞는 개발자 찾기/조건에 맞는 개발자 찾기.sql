SELECT distinct ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS a, SKILLCODES b
WHERE skill_code & code > 0 AND name IN ('Python', 'C#')
ORDER BY id