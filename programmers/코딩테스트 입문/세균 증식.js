// https://school.programmers.co.kr/learn/courses/30/lessons/120910
// 본인 풀이
function solution(n, t) {
  return n * Math.pow(2, t)
}

// 다른 사람의 풀이 - 시프트 연산 활용
function solution(n, t) {
  return n << t;
}