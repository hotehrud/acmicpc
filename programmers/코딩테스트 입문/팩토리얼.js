// https://school.programmers.co.kr/learn/courses/30/lessons/120848
// 본인 풀이
function solution(n) {
  const store = Array(10).fill(10).map(((value, index) => factorial(value - index)))
  let index = 0
  while(index < 10) {
    if (n >= store[index]) {
      break;
    }
    ++index
  }
  return 10 - index
}

function factorial(n) {
  if (n === 1) {
    return 1
  }
  return n * factorial(n - 1)
}

// 다른 사람의 풀이 - n 을 함께 넣고 indexOf 로 찾기
let solution=n=>10-[0,1,2,6,24,120,720,5040,40320,362880,3628800,n].sort((a,b)=>a-b).reverse().indexOf(n)