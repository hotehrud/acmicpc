// https://school.programmers.co.kr/learn/courses/30/lessons/120840
// 본인 풀이 - nCr
function solution(balls, share) {
  const a = Array(balls - (balls - share)).fill(balls).reduce((acc, val, idx) => acc * (val - idx), 1)
  const b = Array(share).fill(share).reduce((acc, val, idx) => acc * (val - idx), 1)
  return a / b
}

// 다른 사람의 풀이
const 팩토리얼 = (num) => num === 0 ? 1 : num * 팩토리얼(num - 1)

function solution(balls, share) {
  return Math.round(팩토리얼(balls) / 팩토리얼(balls - share) / 팩토리얼(share))
}