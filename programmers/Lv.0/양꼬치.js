// https://school.programmers.co.kr/learn/courses/30/lessons/120830
// 본인 풀이
function solution(n, k) {
  const freeBeverage = Math.floor(n / 10)
  return n * 12000 + (k - freeBeverage) * 2000
}

// 다른 사람의 풀이 - 틸드 ~~ === Math.floor
function solution(n, k) {
  k-=~~(n/10);
  if (k < 0) k = 0;
  return n*12000+k*2000;
}