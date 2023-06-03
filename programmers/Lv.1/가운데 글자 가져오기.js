// https://school.programmers.co.kr/learn/courses/30/lessons/12903
// 본인 풀이
function solution(s) {
  const middle = Math.ceil(s.length / 2) - 1
  return s[middle] + (s.length % 2 === 0 ? s[middle + 1] : '')
}

// 다른 사람의 풀이
function solution(s) {
  return s.substr(Math.ceil(s.length / 2) - 1, s.length % 2 === 0 ? 2 : 1);
}