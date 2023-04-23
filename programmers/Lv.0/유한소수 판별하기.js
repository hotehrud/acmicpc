// https://school.programmers.co.kr/learn/courses/30/lessons/120878
// 본인 풀이 - Gcd + 유한소수 판별
function solution(a, b) {
  const gcd = (a, b) => {
    let v1 = Math.min(a, b)
    let v2 = Math.max(a, b)

    while(v1 > 0) {
      const temp = v2 % v1
      v2 = v1
      v1 = temp
    }
    return v2
  }
  const isInfiniteDecimalNumber = (n) => {
    const list = []
    let i = 2
    while(n > 1) {
      if (n % i === 0) {
        list.push(i)
        n /= i
        continue
      }
      ++i
    }
    return list.every(value => value === 2 || value === 5) ? 1 : 2
  }
  return isInfiniteDecimalNumber(b / gcd(a, b))
}

// 다른 사람의 풀이 - GCD 는 유클리드 호제법 말고도 심플한 방법 존재 + 유한소수는 2,5 각각으로 계속 나누어서 1인지만 확인
function solution(a, b) {
  let n = 1;
  for (let i = 1; i <= Math.min(a,b); i++) {
    if (a%i===0 && b%i===0) n = i;
  }

  b/=n;
  while (b%2===0) b/=2;
  while (b%5===0) b/=5;

  return b === 1 ? 1 : 2;
}