// https://school.programmers.co.kr/learn/courses/30/lessons/120826
// 본인 풀이
function solution(my_string, letter) {
  return my_string.replaceAll(letter, '');
}

function solution(my_string, letter) {
  const answer = my_string.split(letter).join('')
  return answer;
}