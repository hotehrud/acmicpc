// https://school.programmers.co.kr/learn/courses/30/lessons/120860
// 본인 풀이
function solution(dots) {
  const arrayX = dots.map(item => item[0])
  const arrayY = dots.map(item => item[1])
  const width = Math.max(...arrayX) - Math.min(...arrayX)
  const height = Math.max(...arrayY) - Math.min(...arrayY)
  return width * height;
}

// 다른 사람의 풀이
const solution = dots => {
  const x = [...new Set(dots.map(p => p[0]))]
  const y = [...new Set(dots.map(p => p[1]))]
  return Math.abs((x[0] - x[1]) * (y[0] - y[1]))
}