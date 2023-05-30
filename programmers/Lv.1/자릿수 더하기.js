// https://school.programmers.co.kr/learn/courses/30/lessons/12931
// 본인 풀이
function solution(n)
{
  let sum = 0
  while(n > 0) {
    sum += n % 10
    n = Math.floor(n / 10)
  }
  return sum
}

// 다른 사람의 풀이
function solution(n){
  // 쉬운방법
  return (n+"").split("").reduce((acc, curr) => acc + parseInt(curr), 0)
}