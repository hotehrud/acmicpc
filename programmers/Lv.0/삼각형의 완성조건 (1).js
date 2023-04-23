// https://school.programmers.co.kr/learn/courses/30/lessons/120889
// 본인 풀이
function solution(sides) {
  const max = Math.max(...sides)
  return max < sides.reduce((acc, value) => acc + value, 0) - max ? 1 : 2
}