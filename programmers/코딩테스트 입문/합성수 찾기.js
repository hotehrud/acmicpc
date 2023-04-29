// https://school.programmers.co.kr/learn/courses/30/lessons/120846
// 본인 풀이
function solution(n) {
  const items = []
  for(let i = 4; i <= n; i++) {
    if (!isPrime(i)) {
      items.push(i)
    }
  }
  return items.length
}

function isPrime(n) {
  if (n === 2) {
    return true
  }
  for(let i = 2; i <= Math.sqrt(n); i++) {
    if (n % i === 0) {
      return false
    }
  }
  return true
}

// 다른 사람의 풀이 - DP
function solution(n) {
  let dp = new Array(n+1).fill(1)
  for(let i = 2 ; i <= n ; i++){
    if(dp[i]){
      for(let j = 2 ; i*j <= n ; j++){
        dp[i*j] = 0
      }
    }
  }

  return dp.filter(el => el === 0).length
}