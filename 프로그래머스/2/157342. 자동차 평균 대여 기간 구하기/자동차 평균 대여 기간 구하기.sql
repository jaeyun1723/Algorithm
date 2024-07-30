-- 코드를 입력하세요
SELECT car_id, round(avg(DATEDIFF(end_date,start_date)+1),1) as AVERAGE_DURATION
FROM car_rental_company_rental_history
GROUP BY car_id
HAVING AVERAGE_DURATION>=7
ORDER BY AVERAGE_DURATION DESC, car_id DESC;
