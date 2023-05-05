-- https://school.programmers.co.kr/learn/courses/30/lessons/132201
-- 본인 풀이
SELECT
    PT_NAME,
    PT_NO,
    GEND_CD,
    AGE,
    CASE WHEN TLNO is not null
             then TLNO
         else 'NONE'
        end
FROM PATIENT
WHERE GEND_CD = 'W' AND AGE <= 12
ORDER BY AGE DESC, PT_NAME


-- 다른 사람의 풀이
SELECT PT_NAME, PT_NO, GEND_CD, AGE, COALESCE(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC;