// https://school.programmers.co.kr/learn/courses/30/lessons/120585
// 본인 풀이
function solution(array, height) {
  const musseuk = [...array, height].sort((a, b) => a - b).lastIndexOf(height)
  return array.length - musseuk
}

// 다른 사람의 풀이
function solution(array, height) {
  var answer = array.filter(item => item > height);
  return answer.length;
}