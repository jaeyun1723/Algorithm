WITH RECURSIVE CNT 
AS ( 
    SELECT id, parent_id, 1 as generation
    FROM ECOLI_DATA
    WHERE parent_id IS NULL
    
    UNION ALL
    
    SELECT e.id, e.parent_id, c.generation + 1 
    FROM ECOLI_DATA e
    JOIN CNT c
    ON e.parent_id = c.id
)

SELECT count(*) as count, generation
FROM CNT
WHERE ID NOT IN (SELECT distinct parent_id FROM cnt WHERE parent_id IS NOT NULL)
GROUP BY generation
ORDER BY generation