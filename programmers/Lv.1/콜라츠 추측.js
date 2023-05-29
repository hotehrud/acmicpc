// https://school.programmers.co.kr/learn/courses/30/lessons/12943
// 본인 풀이
function solution(num) {
  let cnt = 0
  let n = num
  while(n > 1) {
    if (n % 2 === 0) {
      n /= 2
    } else {
      n = n * 3 + 1
    }
    cnt += 1
  }
  return cnt > 500 ? -1 : cnt
}

// 다른 사람의 풀이
const solution = (num) => collatzGuessCount(num, 0);

const collatzGuessCount = (num, acc) =>
  (num === 1) ? ((acc > 500) ? -1 : acc) : collatzGuessCount(processCollatz(num), acc + 1);

const processCollatz = (num) => (num % 2 === 0) ? (num / 2) : (num * 3 + 1);