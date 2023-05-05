-- https://school.programmers.co.kr/learn/courses/30/lessons/131528
-- 본인 풀이
SELECT
    COUNT(*) as USERS
FROM USER_INFO
WHERE AGE IS null

-- 다른 사람의 풀이
SELECT count(*)-count(age) as users from user_info
SELECT COUNT(IF(AGE IS NULL, USER_ID, NULL)) USERS
FROM USER_INFO;