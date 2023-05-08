-- https://school.programmers.co.kr/learn/courses/30/lessons/59037
-- 본인 풀이
SELECT
    ANIMAL_ID,
    NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID

-- 다른 사람의 풀이
SELECT animal_id, name
from animal_ins
where intake_condition not like 'Aged'
order by ANIMAL_ID