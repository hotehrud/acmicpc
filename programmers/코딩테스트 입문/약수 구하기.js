// https://school.programmers.co.kr/learn/courses/30/lessons/120897
// 본인 풀이
function solution(n) {
  return Array(n).fill(1).map((v, i) => v + i).filter(item => Number.isInteger(n / item))
}

// 다른 사람의 풀이 - 제곱근 활용해서 불필요한 탐색 횟수 절감
function solution(n) {
  let s = new Set();
  for (let i = 1; i <= Math.sqrt(n); i++) {
    if (n%i === 0) {
      s.add(i);
      s.add(n/i);
    }
  }
  return [...s].sort((a,b)=>a-b);
}