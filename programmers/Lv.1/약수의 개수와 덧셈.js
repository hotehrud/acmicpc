// https://school.programmers.co.kr/learn/courses/30/lessons/77884
// 본인 풀이
function solution(left, right) {
  const getDivisor = (n) => {
    if (n === 1) return 1
    if (n === 2) return 2
    let cnt = 2
    for(let i = 2; i <= n / 2; i++) {
      if (n % i === 0) {
        ++cnt
      }
    }
    return cnt
  }

  let sum = [0, 0]
  for(let i = left; i <= right; i++) {
    let cnt = getDivisor(i)
    sum[cnt % 2 === 0 ? 1 : 0] += i
  }
  return sum[1] - sum[0]
}

// 다른 사람의 풀이 - 제곱근이 정수이면, 약수의 개수는 홀수.
function solution(left, right) {
  var answer = 0;
  for (let i = left; i <= right; i++) {
    if (Number.isInteger(Math.sqrt(i))) {
      answer -= i;
    } else {
      answer += i;
    }
  }
  return answer;
}