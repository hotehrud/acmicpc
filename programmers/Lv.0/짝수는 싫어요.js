// https://school.programmers.co.kr/learn/courses/30/lessons/120813
// 본인 풀이
function solution(n) {
  return Array(Math.ceil(n / 2)).fill(0).map((v, i) => i * 2 + 1)
}

// 다른 사람의 풀이
const solution = (n) =>
  Array
    .from({ length: n }, (_, i) => i + 1)
    .filter(i => i % 2 !== 0)