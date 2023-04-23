// https://school.programmers.co.kr/learn/courses/30/lessons/120868
// 본인 풀이 - 가장 길이가 긴 변이 a,b일 경우 || c 일 경우
function solution(sides) {
  const [a, b] = sides
  let max = Math.max(a, b)
  let min = Math.min(a, b)

  const fromSides = max - (max - min)
  const fromOtherOne = (max + min - 1) - max
  return fromSides + fromOtherOne
}

// 다른 사람의 풀이 -  a > c => b + c > a > c => a > c > a-b => c 의 정수 개수 = b-1
function solution(sides) {
  return Math.min(...sides)*2-1
}