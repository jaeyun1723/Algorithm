SELECT month(start_date) as month , car_id, count(history_id) as records
FROM car_rental_company_rental_history
WHERE date_format(start_date,'%Y-%m') BETWEEN '2022-08' AND '2022-10' AND
    car_id IN ( SELECT car_id
               FROM car_rental_company_rental_history
               WHERE date_format(start_date,'%Y-%m') BETWEEN '2022-08' AND '2022-10'
               GROUP BY car_id
               HAVING count(history_id)>=5 )
GROUP BY month, car_id
ORDER BY month, car_id DESC


