-- https://school.programmers.co.kr/learn/courses/30/lessons/131535
-- 본인 풀이
SELECT
    COUNT(*) as USERS
FROM USER_INFO
WHERE AGE >= 20 AND AGE <= 29
          AND YEAR(JOINED) = '2021'

-- 다른 사람의 풀이
SELECT COUNT(USER_ID) AS USERS
FROM USER_INFO
WHERE JOINED LIKE '2021%'
  AND AGE BETWEEN 20 AND 29