-- 코드를 입력하세요
SELECT car_id, a.car_type, floor(daily_fee*30*(1-discount_rate/100)) as fee
FROM CAR_RENTAL_COMPANY_CAR as a JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN as b on a.car_type=b.car_type
WHERE car_id NOT IN (SELECT  car_id
                    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                    WHERE end_date >= '2022-11-01' AND start_date <= '2022-12-01')
AND duration_type = '30일 이상'
AND a.car_type IN ('세단', 'SUV')
AND floor(daily_fee*30*(1-discount_rate/100))>=500000 and floor(daily_fee*30*(1-discount_rate/100))<2000000
order by fee desc, car_type, car_id desc