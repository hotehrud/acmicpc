// https://school.programmers.co.kr/learn/courses/30/lessons/120837
// 본인 풀이
function solution(hp) {
  const A = 5
  const B = 3
  const C = 1
  const countA = Math.floor(hp / A)
  hp -= Math.floor(hp / A) * A
  const countB = Math.floor(hp / B)
  hp -= Math.floor(hp / B) * B
  const countC = Math.floor(hp / C)
  return countA + countB + countC
}

// 다른 사람의 풀이 - 나머지 활용
function solution(hp) {
  return Math.floor(hp/5)+Math.floor((hp%5)/3)+(hp%5)%3;
}