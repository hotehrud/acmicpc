// https://school.programmers.co.kr/learn/courses/30/lessons/120906
// 본인 풀이 - 각 자릿수 뽑기 - 메모리 절약
function solution(n) {
  let sum = 0
  while(n > 0) {
    sum += n % 10
    n = Math.floor(n / 10)
  }
  return sum
}

// 다른 사람의 풀이
function solution(n) {
  return n
    .toString()
    .split("")
    .reduce((acc, cur) => acc + Number(cur), 0);
}