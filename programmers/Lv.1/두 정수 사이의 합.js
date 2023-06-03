// https://school.programmers.co.kr/learn/courses/30/lessons/12912
// 본인 풀이 - 가우스
function solution(a, b) {
  if (a === b) {
    return a
  }
  const diff = a - b
  const cnt = Math.abs(diff + (diff > 0 ? 1 : -1))
  let ans = (a + b) * Math.floor(cnt / 2)
  if ((a - b) % 2 === 0) {
    ans += Math.floor((a + b) / 2)
  }
  return ans
}

// 다른 사람의 풀이 - (등차수열의 합) = {(첫 항 + 마지막 항) * (항의 개수)} / 2
function solution(a, b) {
  return (a+b) * (Math.abs(a-b)+1) / 2;
}