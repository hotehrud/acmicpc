// https://school.programmers.co.kr/learn/courses/30/lessons/132267
// 본인 풀이
function solution(a, b, n) {
  let bottle = n
  let result = 0
  while(bottle >= a) {
    const changed = Math.floor(bottle / a)
    result += changed * b
    bottle = bottle - changed * a + changed * b
  }
  return result
}

// 다른 사람의 풀이
function solution(a, b, n) {
  let answer = 0;
  while (n >= a) {
    answer += parseInt(n / a) * b;
    n = parseInt(n / a) * b + n % a;
  }
  return answer;
}