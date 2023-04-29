// https://school.programmers.co.kr/learn/courses/30/lessons/120912
// 본인 풀이
function solution(array) {
  return array.reduce((acc, value) => {
    return acc + String(value).split('').filter(item => item === '7').length
  }, 0)
}

// 다른 사람의 풀이 - 배열을 하나의 문자열로 만든 후 7 기준으로 분리
function solution(array) {
  return array.join('').split('7').length-1;
}