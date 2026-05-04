SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE skill_code & (SELECT code FROM skillcodes WHERE name='Python')
OR skill_code & (SELECT code FROM skillcodes WHERE name='C#')
ORDER BY id