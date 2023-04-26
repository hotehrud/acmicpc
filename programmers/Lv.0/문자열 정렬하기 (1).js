// https://school.programmers.co.kr/learn/courses/30/lessons/120850
// 본인 풀이
function solution(my_string) {
  var answer = [];
  return my_string.replaceAll(/[a-z]/g, '').split('').map(item => Number(item)).sort((a, b) => a - b);
}

// 다른 사람의 풀이 - isNaN 활용
function solution(my_string) {
  return my_string.split("").filter((v) => !isNaN(v)).map((v) => v*1).sort((a,b) => a-b)
}