// https://school.programmers.co.kr/learn/courses/30/lessons/120886
// 본인 풀이
function solution(before, after) {
  return before.split('').sort().join('') === after.split('').sort().join('') ? 1 : 0
}