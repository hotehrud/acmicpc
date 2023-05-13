// https://school.programmers.co.kr/learn/courses/30/lessons/68935
// 본인 풀이
function solution(n) {
  return parseInt(n.toString(3).split('').reverse().join('').toString(10), 3)
}

// 다른 사람의 풀이
function solution(n) {
  const answer = [];
  while(n !== 0) {
    answer.unshift(n % 3);
    n = Math.floor(n/3);
  }
  return answer.reduce((acc,v,i) => acc + (v * Math.pow(3, i)),0);
}

const solution = (n) => {
  return parseInt([...n.toString(3)].reverse().join(""), 3);
}