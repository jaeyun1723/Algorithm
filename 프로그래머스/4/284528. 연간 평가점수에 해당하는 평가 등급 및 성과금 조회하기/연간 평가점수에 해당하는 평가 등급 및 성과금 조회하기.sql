-- 사원별 성과금 정보 조회
SELECT em.emp_no, emp_name, grade, case
                                    when grade='S' then sal*0.2
                                    when grade='A' then sal*0.15
                                    when grade='B' then sal*0.1
                                    else 0 end as bonus
FROM hr_employees as em JOIN (SELECT emp_no, case
                                              when avg(score) >= 96 then 'S'
                                              when avg(score) >= 90 then 'A'
                                              when avg(score) >= 80 then 'B'
                                              else 'C' end as grade
                              FROM hr_grade
                              GROUP BY emp_no) as g on em.emp_no=g.emp_no
ORDER BY em.emp_no
