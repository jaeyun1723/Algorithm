SELECT id
FROM ECOLI_DATA
WHERE parent_id IN (SELECT id
                    FROM ECOLI_DATA
                    WHERE parent_id IN (SELECT id
                                        FROM ECOLI_DATA
                                        WHERE parent_id IS NULL))
ORDER BY id
