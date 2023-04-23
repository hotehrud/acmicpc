// https://school.programmers.co.kr/learn/courses/30/lessons/120888
// 본인 풀이
function solution(my_string) {
  return my_string.split('').reduce((acc, val) => {
    return acc += acc.indexOf(val) > -1 ? '' : val
  }, '')
}

// 다른 사람의 풀이 - Set 으로 중복 제거
function solution(my_string) {
  return [...new Set(my_string)].join('');
}
