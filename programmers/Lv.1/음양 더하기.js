// https://school.programmers.co.kr/learn/courses/30/lessons/76501
// 본인 풀이
function solution(absolutes, signs) {
  return absolutes.reduce((acc, val, idx) => {
    acc += val * (signs[idx] ? 1 : -1)
    return acc
  }, 0)
}
