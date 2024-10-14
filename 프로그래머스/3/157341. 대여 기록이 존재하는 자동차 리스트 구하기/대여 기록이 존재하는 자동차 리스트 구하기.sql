SELECT distinct(car_id)
FROM car_rental_company_rental_history
WHERE car_id IN (SELECT car_id
                FROM car_rental_company_car
                WHERE car_type='세단') AND month(start_date)=10
ORDER BY car_id DESC;