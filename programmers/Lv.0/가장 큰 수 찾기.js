// https://school.programmers.co.kr/learn/courses/30/lessons/120899
// 본인 풀이
function solution(array) {
  const max = Math.max(...array)
  const index = array.indexOf(max)
  return [max, index]
}