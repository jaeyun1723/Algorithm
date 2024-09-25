SELECT d.dept_id, d.dept_name_en, round(avg(e.sal)) as avg_sal
FROM hr_department as d
JOIN hr_employees as e 
ON d.dept_id=e.dept_id
GROUP BY dept_id
ORDER BY avg_sal DESC
