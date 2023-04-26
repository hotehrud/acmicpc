// https://school.programmers.co.kr/learn/courses/30/lessons/120852
// 본인 풀이 - 소수 구하기 + 소인수분해
function solution(n) {
  const items = new Set()
  while(n !== 1) {
    for(let j = 2; j <= n; j++) {
      if (isPrime(j) && n % j === 0) {
        items.add(j)
        n = n / j
        break
      }
    }
  }
  return Array.from(items)
}

function isPrime(n) {
  if (n === 2) {
    return true
  }
  for(let i = 2; i < Math.sqrt(n); i++) {
    if (n % i === 0) {
      return false
    }
  }
  return true
}

// 다른 사람의 풀이 - 소수를 구할 필요가 없음. 매번 2부터 시작하고 4, 6 2배수로 갈 수가 없음
function solution(n) {
  let answer = []

  let i = 2;
  while (i <= n) {
    if (n % i === 0) {
      answer.push(i)
      n = n / i
    } else {
      i++
    }
  }

  return [...new Set(answer.sort((a, b) => a > b ? 1 : -1))]
}