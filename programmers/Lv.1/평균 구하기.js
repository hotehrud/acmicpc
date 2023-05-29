// https://school.programmers.co.kr/learn/courses/30/lessons/12944
// 본인 풀이
function solution(arr) {
  return arr.reduce((acc, val) => acc + val, 0) / arr.length;
}
