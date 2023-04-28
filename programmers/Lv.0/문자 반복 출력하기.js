// https://school.programmers.co.kr/learn/courses/30/lessons/120825
// 본인 풀이
function solution(my_string, n) {
  return my_string.split('').reduce((acc, val) => acc + Array(n).fill(val).join(''), '');
}

// 다른 사람의 풀이 - String.repeat
function solution(my_string, n) {
  var answer = [...my_string].map(v => v.repeat(n)).join("");
  return answer;
}