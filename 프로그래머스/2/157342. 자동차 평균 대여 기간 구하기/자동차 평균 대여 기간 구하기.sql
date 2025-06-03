SELECT car_id as CAR_ID, round(avg(diff),1) as AVERAGE_DURATION
FROM (SELECT car_id, datediff(end_date, start_date)+1 as diff
      FROM car_rental_company_rental_history) as car_table
GROUP BY car_id
HAVING avg(diff)>=7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC

