// https://school.programmers.co.kr/learn/courses/30/lessons/12947
// 본인 풀이
function solution(x) {
  const sum = String(x).split('').reduce((acc, val) => {
    return acc + +val
  }, 0)
  return x % sum === 0
}

// 다른 사람의 풀이
function solution(n) {
  return !(n % (n + "").split("").reduce((a, b) => +b + +a ));
}