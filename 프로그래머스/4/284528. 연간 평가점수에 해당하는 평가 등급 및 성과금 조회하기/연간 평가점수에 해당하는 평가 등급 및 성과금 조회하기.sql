SELECT a.emp_no, emp_name, CASE
                            WHEN ms>=96 THEN 'S'
                            WHEN ms>=90 THEN 'A'
                            WHEN ms>=80 THEN 'B'
                         ELSE 'C'
                         END as grade, 
                         CASE
                            WHEN ms>=96 THEN sal*0.2
                            WHEN ms>=90 THEN sal*0.15
                            WHEN ms>=80 THEN sal*0.1
                         ELSE 0
                         END as bonus
FROM hr_employees a JOIN (SELECT emp_no, avg(score) as ms
                          FROM hr_grade
                          GROUP BY emp_no) b ON a.emp_no = b.emp_no
ORDER BY a.emp_no
