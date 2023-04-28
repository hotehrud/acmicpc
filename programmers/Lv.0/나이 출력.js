// https://school.programmers.co.kr/learn/courses/30/lessons/120820
// 본인 풀이
function solution(age) {
  return 2022 - age + 1;
}

// 다른 사람의 풀이
function solution(age) {
  return new Date().getFullYear() - age + 1;
}
