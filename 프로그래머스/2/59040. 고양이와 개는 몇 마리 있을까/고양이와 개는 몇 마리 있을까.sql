SELECT animal_type, count(*)
FROM animal_ins
WHERE animal_type IN ('Cat','Dog')
GROUP BY animal_type
ORDER BY animal_type