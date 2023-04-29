// https://school.programmers.co.kr/learn/courses/30/lessons/120834
// 본인 풀이
function solution(age) {
  return ('' + age).split('').reduce((acc, val) => {
    return `${acc}${String.fromCharCode((Number(val) + 97))}`
  }, '')
}

// 다른 사람의 풀이
function solution(age) {
  return age
    .toString()
    .split("")
    .map((v) => "abcdefghij"[v])
    .join("");
}