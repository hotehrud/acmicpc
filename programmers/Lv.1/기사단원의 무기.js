// https://school.programmers.co.kr/learn/courses/30/lessons/136798
// 본인 풀이
function solution(number, limit, power) {
  return Array(number)
    .fill(1)
    .map((v, i) => v + i)
    .reduce((acc, val) => {
      const n = getDivisorCount(val)
      return acc + (n <= limit ? n : power)
    }, 0)
}

function getDivisorCount(value) {
  let cnt = 1
  for (let i = 1; i <= value / 2; i++) {
    if (value % i === 0) {
      cnt += 1
    }
  }
  return cnt
}