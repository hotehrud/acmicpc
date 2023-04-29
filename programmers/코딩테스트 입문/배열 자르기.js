// https://school.programmers.co.kr/learn/courses/30/lessons/120833
// 본인 풀이
function solution(numbers, num1, num2) {
  return numbers.slice(num1, num2 + 1);
}

// 다른 사람의 풀이
function solution(numbers, num1, num2) {
  return numbers.splice(num1, num2-num1+1);
}