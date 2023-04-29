// https://school.programmers.co.kr/learn/courses/30/lessons/120891
// 본인 풀이
function solution(order) {
  let num = order
  let clap = 0
  while(num > 0) {
    const target = num % 10
    if (target > 0 && target % 3 === 0) {
      ++clap
    }
    num = Math.floor(num / 10)
  }
  return clap
}

// 다른 사람의 풀이 - 정규식
function solution(order) {
  var answer = [...order.toString().matchAll(/[3|6|9]/g)].length;
  return answer;
}