-- https://school.programmers.co.kr/learn/courses/30/lessons/59415
-- 본인 풀이
SELECT
    max(datetime)
FROM animal_ins

-- 다른 사람의 풀이
SELECT datetime as 시간
from animal_ins
where datetime = (select max(datetime) from animal_ins);

SELECT datetime as 시간
from animal_ins
order by datetime desc limit 1
