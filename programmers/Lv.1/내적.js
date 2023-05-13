// https://school.programmers.co.kr/learn/courses/30/lessons/70128
// 본인 풀이
function solution(a, b) {
  return a.reduce((acc, val, idx) => {
    acc += a[idx] * b[idx]
    return acc
  }, 0)
}