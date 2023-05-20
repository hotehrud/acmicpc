// https://school.programmers.co.kr/learn/courses/30/lessons/42748
// 본인 풀이
function solution(array, commands) {
  return commands.map(
    ([i, j, k]) => array.slice(i - 1, j).sort((a, b) => a - b)[k - 1],
  )
}
