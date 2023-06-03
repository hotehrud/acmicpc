// https://school.programmers.co.kr/learn/courses/30/lessons/12922
// 본인 풀이
function solution(n) {
  const items = ['수', '박']
  return Array(n).fill('').map((_, i) => i % 2 === 0 ? items[0] : items[1]).join('')
}

// 다른 사람의 풀이
function solution(n) {
  return "수박".repeat(n).slice(0,n)
}