// https://school.programmers.co.kr/learn/courses/30/lessons/120818
// 본인 풀이
function solution(price) {
  let result = 0
  if (price >= 500000) {
    result = price - price * 0.2
  } else if (price >= 300000) {
    result = price - price * 0.1
  } else if (price >= 100000) {
    result = price - price * 0.05
  } else {
    result = price
  }
  return Math.floor(result)
}

// 다른 사람의 풀이
const discounts = [
  [500000, 20],
  [300000, 10],
  [100000,  5],
]

const solution = (price) => {
  for (const discount of discounts)
    if (price >= discount[0])
      return Math.floor(price - price * discount[1] / 100)
  return price
}