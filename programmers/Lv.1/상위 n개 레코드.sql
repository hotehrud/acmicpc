-- https://school.programmers.co.kr/learn/courses/30/lessons/59405
-- 본인 풀이
SELECT
    NAME
FROM ANIMAL_INS
WHERE DATETIME IN (SELECT MIN(DATETIME) FROM ANIMAL_INS)

-- 다른 사람의 풀이
SELECT  name
from animal_ins
order by  datetime asc
    limit 1