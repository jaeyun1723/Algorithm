SELECT scores as score, a.emp_no, emp_name, position, email
FROM hr_employees a JOIN (SELECT emp_no, sum(score) as scores
                          FROM hr_grade
                          WHERE year = 2022
                          GROUP BY emp_no
                          ORDER BY scores desc
                          LIMIT 1) b ON a.emp_no = b.emp_no