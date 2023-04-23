// https://school.programmers.co.kr/learn/courses/30/lessons/120905
// 본인 풀이
function solution(n, numlist) {
  return numlist.filter(num => num % n === 0)
}