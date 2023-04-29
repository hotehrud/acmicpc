// https://school.programmers.co.kr/learn/courses/30/lessons/120806
// 본인 풀이
function solution(num1, num2) {
  return Math.floor(num1 / num2 * 1000)
}

// 다른 사람의 풀이
function solution(num1, num2) {
  return Math.trunc(num1 / num2 * 1000);
}