// https://school.programmers.co.kr/learn/courses/30/lessons/120847
// 본인 풀이
function solution(numbers) {
  numbers.sort((a, b) => a - b)
  return numbers.pop() * numbers.pop()
}

// 다른 사람의 풀이 - 구조 분해 활용
function solution(numbers) {
  let [a, b] = numbers.sort((a,b) => b - a);
  return a * b;
}