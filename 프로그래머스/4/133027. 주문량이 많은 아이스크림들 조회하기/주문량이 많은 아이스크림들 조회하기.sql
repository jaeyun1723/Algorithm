SELECT ju.flavor
FROM first_half JOIN (SELECT flavor, sum(total_order) as tot_ju
                      FROM july
                      GROUP BY flavor) as ju
ON first_half.flavor=ju.flavor
ORDER BY (first_half.total_order+ju.tot_ju) DESC
limit 3