// https://school.programmers.co.kr/learn/courses/30/lessons/120908
// 본인 풀이
function solution(str1, str2) {
  return str1.indexOf(str2) > -1 ? 1 : 2
}

// 다른 사람의 풀이
function solution(str1, str2) {
  return str1.split(str2).length > 1 ? 1 : 2
}