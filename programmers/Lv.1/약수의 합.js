// https://school.programmers.co.kr/learn/courses/30/lessons/12928
// 본인 풀이
function solution(n) {
  let sum = 0
  for(let i = 1; i <= Math.sqrt(n); i++) {
    if (n % i === 0) {
      sum += i === (n / i) ? i : i + (n / i);
    }
  }
  return sum
}