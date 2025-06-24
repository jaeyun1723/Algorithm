SELECT a.id, count(b.parent_id) AS CHILD_COUNT
FROM ECOLI_DATA as a LEFT JOIN ECOLI_DATA as b ON a.id=b.parent_id
GROUP BY a.id