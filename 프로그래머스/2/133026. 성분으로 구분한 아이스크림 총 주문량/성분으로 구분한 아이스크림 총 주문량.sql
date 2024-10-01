SELECT ingredient_type, sum(total_order) as total_order
FROM first_half as f JOIN icecream_info as i
ON f.flavor=i.flavor
GROUP BY ingredient_type