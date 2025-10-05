SELECT CASE
        WHEN skill_code & (SELECT sum(code)
                           FROM skillcodes
                           WHERE category = 'Front End') AND
             skill_code & (SELECT sum(code)
                           FROM skillcodes
                           WHERE name = 'Python') THEN 'A'
        WHEN skill_code & (SELECT sum(code)
                           FROM skillcodes
                           WHERE name = 'C#') THEN 'B'
        WHEN skill_code & (SELECT sum(code)
                           FROM skillcodes
                           WHERE category = 'Front End') THEN 'C'
        ELSE NULL
        END AS grade, id, email
FROM developers
GROUP BY grade, id, email
HAVING grade IS NOT NULL
ORDER BY grade, id