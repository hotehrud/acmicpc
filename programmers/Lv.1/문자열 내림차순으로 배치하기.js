// https://school.programmers.co.kr/learn/courses/30/lessons/12917
// 본인 풀이
function solution(s) {
  return s.split('').sort().reverse().join('')
}

// 다른 사람의 풀이
function solution(s) {
  return s.split("").sort((a,b) => a<b ? 1:-1).join("")
}
