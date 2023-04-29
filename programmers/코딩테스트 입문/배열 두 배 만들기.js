// https://school.programmers.co.kr/learn/courses/30/lessons/120809
// 본인 풀이
function solution(numbers) {
  return numbers.map(n => n * 2);
}

// 다른 사람의 풀이
function solution(numbers) {
  return numbers.reduce((a, b) => [...a, b * 2], []);
}