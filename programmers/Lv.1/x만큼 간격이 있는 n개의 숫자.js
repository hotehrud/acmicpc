// https://school.programmers.co.kr/learn/courses/30/lessons/12954
// 본인 풀이
function solution(x, n) {
  return Array(n).fill(x).map((val, idx) => val * (idx + 1));
}