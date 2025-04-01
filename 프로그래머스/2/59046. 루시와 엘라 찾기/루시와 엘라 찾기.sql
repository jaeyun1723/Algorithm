-- 코드를 입력하세요
SELECT animal_id, name, sex_upon_intake
FROM ANIMAL_INS
WHERE name regexp '^(Lucy|Ella|Pickle|Rogan|Sabrina|Mitty)$'
ORDER BY animal_id
