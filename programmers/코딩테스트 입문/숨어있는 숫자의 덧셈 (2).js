// https://school.programmers.co.kr/learn/courses/30/lessons/120864
// 본인 풀이
function solution(my_string) {
  return my_string
    .replaceAll(/[A-Za-z]/g, ' ')
    .split(' ')
    .reduce((acc, val) => {
      if (val && Number.isInteger(Number(val))) {
        return acc + Number(val)
      }
      return acc
    }, 0)
}

// 다른 사람의 풀이 - 소문자로 변환하면 정규식을 줄일 수 있음
function solution(my_string) {
  return my_string.toLowerCase().replace(/[a-z]/g, " ").split(" ").map((v) => v*1).reduce((a,b) => a+b)
}

// 다른 사람의 풀이 - 정규식 응용 \D 숫자를 제외한 문자
function solution(my_string) {
  return my_string.split(/\D+/).reduce((acc, cur) => acc + Number(cur), 0);
}