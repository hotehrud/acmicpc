-- https://school.programmers.co.kr/learn/courses/30/lessons/144853
-- 본인 풀이
SELECT
    BOOK_ID,
    DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as 'PUBLISHED_DATE'
FROM BOOK
WHERE YEAR(PUBLISHED_DATE) = '2021'
  AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE ASC