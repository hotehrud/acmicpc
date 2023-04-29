// https://school.programmers.co.kr/learn/courses/30/lessons/120836
// 본인 풀이
function solution(n) {
  let cnt = 0
  const sqrt = Math.floor(Math.sqrt(n))
  for(let i = 1; i <= sqrt; i++) {
    if (n % i === 0) {
      cnt += 1
    }
  }
  return sqrt * sqrt === n ? cnt * 2 - 1 : cnt * 2
}