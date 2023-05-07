// https://school.programmers.co.kr/learn/courses/30/lessons/87389
// 본인 풀이
function solution(n) {
  let i = 2
  while(i < n - 1) {
    if (n % i === 1) {
      break
    }
    i += 1
  }
  return i
}

// 다른 사람의 풀이
function solution(n, x = 1) {
  while (x++) {
    if (n % x === 1) {
      return x;
    }
  }
}