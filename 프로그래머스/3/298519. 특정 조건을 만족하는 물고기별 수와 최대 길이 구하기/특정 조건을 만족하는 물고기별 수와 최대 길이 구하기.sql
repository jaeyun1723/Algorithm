SELECT count(*) as fish_count, max(length) as max_length, fish_type
FROM (SELECT fish_type, case 
                            when length is NULL then 10
                            when length <= 10 then 10
                            else length
                            end as length
      FROM fish_info) as f
GROUP BY fish_type
HAVING avg(length) >= 33
ORDER BY fish_type