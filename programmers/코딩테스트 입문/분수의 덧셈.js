// https://school.programmers.co.kr/learn/courses/30/lessons/120808
// 본인 풀이 - 최소공배수를 통해 두개의 분수를 더한 분수를 최대공약수를 활용해서 기약분수 만들기
function solution(numer1, denom1, numer2, denom2) {
  const denom = lcm(denom1, denom2)
  const numer = numer1 * (denom / denom1) + numer2 * (denom / denom2)
  const n = gcd(numer, denom)
  return [numer / n, denom / n]
}

function gcd(a, b) {
  let max = 0
  for(let i = 1; i <= a && i <= b; i++) {
    if (a % i === 0 && b % i === 0) {
      max = i
    }
  }
  return max
}

function lcm(a, b) {
  let min = Math.max(a, b)
  while(true) {
    if (min % a === 0 && min % b === 0) {
      break
    }
    ++min
  }
  return min
}

// 다른 사람의 풀이 - 두개의 분수를 더한 후, 최대공약수를 통해 기약분수 만들기
function fnGCD(a, b){
  return (a%b)? fnGCD(b, a%b) : b;
}

function solution(denum1, num1, denum2, num2) {
  let denum = denum1*num2 + denum2*num1;
  let num = num1 * num2;
  let gcd = fnGCD(denum, num); //최대공약수

  return [denum/gcd, num/gcd];
}