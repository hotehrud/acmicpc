// https://school.programmers.co.kr/learn/courses/30/lessons/12982
// 본인 풀이
function solution(d, budget) {
  const list = [...d].sort((a, b) => a - b)
  let sum = 0
  let i = 0
  while(sum <= budget) {
    sum += list[i]
    i += 1
  }
  return i - 1
}


// 다른 사람의 풀이
function solution(d, budget) {
  return d.sort((a, b) => a - b).reduce((count, price) => {
    return count + ((budget -= price) >= 0);
  }, 0);
}