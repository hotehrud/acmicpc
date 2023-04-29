// https://school.programmers.co.kr/learn/courses/30/lessons/120843
// 본인 풀이
function solution(numbers, k) {
  return numbers[((k - 1) * 2) % numbers.length]
}