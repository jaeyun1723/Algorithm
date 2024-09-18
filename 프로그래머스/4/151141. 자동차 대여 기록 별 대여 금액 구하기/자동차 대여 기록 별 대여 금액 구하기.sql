-- 코드를 입력하세요
SELECT c.history_id, CASE
                        WHEN c.duration_type='없음'
                        THEN floor(c.daily_fee*c.duration)
                        ELSE
                        floor(c.daily_fee*c.duration*(1-discount_rate/100))
                        END as fee
FROM (SELECT b.history_id, b.car_id, a.car_type, a.daily_fee, datediff(b.end_date, b.start_date)+1 as duration,
      CASE
      WHEN datediff(b.end_date,b.start_date)+1 >=90 THEN '90일 이상'
      WHEN datediff(b.end_date,b.start_date)+1 >=30 THEN '30일 이상'
      WHEN datediff(b.end_date,b.start_date)+1 >=7 THEN '7일 이상'
      ELSE
      '없음'
      END as duration_type
        FROM car_rental_company_car as a JOIN car_rental_company_rental_history as b
        ON a.car_id=b.car_id
        WHERE car_type='트럭') as c
LEFT OUTER JOIN car_rental_company_discount_plan as d
ON c.car_type=d.car_type and c.duration_type=d.duration_type
ORDER BY fee DESC, history_id DESC

