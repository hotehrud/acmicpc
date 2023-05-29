// https://school.programmers.co.kr/learn/courses/30/lessons/12940
// 본인 풀이
function solution(n, m) {
  return [gcd(n, m), lcm(n, m)];
}

function gcd(a, b) {
  return a > 0 ? gcd(b % a, a) : b
}

function lcm(a, b) {
  return a * b / gcd(a, b)
}
