// https://school.programmers.co.kr/learn/courses/30/lessons/120815
// 본인 풀이
function solution(n) {
  let result = 0
  for(let i = 6; i <= 600; i += 6) {
    if (i % n === 0) {
      result = i / 6
      break
    }
  }
  return result
}

// 다른 사람의 풀이
function solution(n) {
  return Array(6).fill(n).map((v,idx) => v = v * (idx + 1)).find((v) => v % 6 === 0 ) / 6;
}