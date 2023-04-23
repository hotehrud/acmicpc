// https://school.programmers.co.kr/learn/courses/30/lessons/120903
// 본인 풀이
function solution(s1, s2) {
  return s1.filter(item => s2.includes(item)).length
}