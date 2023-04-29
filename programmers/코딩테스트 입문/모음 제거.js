// https://school.programmers.co.kr/learn/courses/30/lessons/120849
// 본인 풀이
function solution(my_string) {
  return my_string.replaceAll(/[a|e|i|o|u]/g, '')
}

// 다른 사람의 풀이
function solution(my_string) {
  return my_string.replace(/[aeiou]/g, '');
}