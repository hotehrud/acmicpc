// https://school.programmers.co.kr/learn/courses/30/lessons/12921
// 본인 풀이
function solution(n) {
  const prime = Array(n + 1).fill(true)
  prime[1] = false

  for(let i = 2; i <= Math.sqrt(n); i++) {
    for(let j = i * i; j <= n; j += i) {
      prime[j] = false
    }
  }

  return Array(n).fill(0).map((v, i) => v + i + 1).reduce((acc, val) => {
    acc += prime[val]
    return acc
  }, 0)
}
