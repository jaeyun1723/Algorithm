SELECT hour(datetime) as hour, count(*) as count
FROM animal_outs
GROUP BY hour(datetime)
HAVING hour BETWEEN 9 AND 19
ORDER BY hour(datetime)