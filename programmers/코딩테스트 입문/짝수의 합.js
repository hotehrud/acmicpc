// https://school.programmers.co.kr/learn/courses/30/lessons/120831
// 본인 풀이
function solution(n) {
  return Array(n)
    .fill(n)
    .map((v, i) => v - i)
    .reduce((acc, val) => (val % 2 === 0 ? acc + val : acc), 0)
}

// 다른 사람의 풀이
function solution(n) {
  var half = Math.floor(n/2);
  return half*(half+1);
}

function solution(n) {
  var answer = 0;

  for(let i=2 ; i<=n ; i+=2)
    answer += i;

  return answer;
}
