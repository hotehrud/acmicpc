-- https://school.programmers.co.kr/learn/courses/30/lessons/151136
-- 본인 풀이
SELECT
    ROUND(AVG(DAILY_FEE)) as AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'