-- https://school.programmers.co.kr/learn/courses/30/lessons/132203
-- 본인 풀이
SELECT
    DR_NAME,
    DR_ID,
    MCDP_CD,
    DATE_FORMAT(HIRE_YMD, '%Y-%m-%d')
FROM DOCTOR
WHERE MCDP_CD = 'CS' or MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME

-- MCDP_CD IN ('cs', 'gs')