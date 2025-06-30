SELECT id, CASE 
            WHEN rank_num <= 0.25 THEN 'CRITICAL'
            WHEN rank_num <= 0.5 THEN 'HIGH'
            WHEN rank_num <= 0.75 THEN 'MEDIUM'
            ELSE 'LOW'
           END AS colony_name
FROM (SELECT id, percent_rank() over(order by size_of_colony desc) as rank_num
      FROM ecoli_data
      ORDER BY id) as a