// https://school.programmers.co.kr/learn/courses/30/lessons/120851
// 본인 풀이
function solution(my_string) {
  return my_string
    .toLocaleLowerCase()
    .replaceAll(/[a-z]/g, '')
    .split('')
    .reduce((acc, value) => {
      return acc + Number(value)
    }, 0)
}
