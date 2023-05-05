-- https://school.programmers.co.kr/learn/courses/30/lessons/131112
-- 본인 풀이
SELECT
    FACTORY_ID,
    FACTORY_NAME,
    ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '%강원도%'
ORDER BY FACTORY_ID