SELECT a.year, b.maximum - a.size_of_colony as year_dev, id 
FROM (SELECT YEAR(differentiation_date) as year, size_of_colony, id
      FROM ecoli_data) a
JOIN
      (SELECT YEAR(differentiation_date) as year, MAX(size_of_colony) as maximum
       FROM ECOLI_DATA
       GROUP BY YEAR(differentiation_date)) b
ON a.year = b.year
ORDER BY a.year, year_dev