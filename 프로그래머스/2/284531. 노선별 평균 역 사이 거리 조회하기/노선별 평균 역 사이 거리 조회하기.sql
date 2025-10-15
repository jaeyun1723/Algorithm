SELECT route, CONCAT(ROUND(sum(d_between_dist),1),'km') as total_distance , CONCAT(ROUND(sum(d_between_dist)/count(route),2),'km') as average_distance
FROM subway_distance
GROUP BY route
ORDER BY ROUND(sum(d_between_dist),1) desc