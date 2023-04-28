// https://school.programmers.co.kr/learn/courses/30/lessons/120817
// 본인 풀이
function solution(numbers) {
  return numbers.reduce((acc, val) => acc + val, 0) / numbers.length;
}