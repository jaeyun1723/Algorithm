SELECT a.dept_id, dept_name_en, ROUND(avg(sal)) as avg_sal
FROM hr_department a JOIN hr_employees b ON a.dept_id = b.dept_id
GROUP BY a.dept_id
ORDER BY avg_sal DESC