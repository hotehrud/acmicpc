// https://school.programmers.co.kr/learn/courses/30/lessons/86051
// 본인 풀이
function solution(numbers) {
  const [start, end, length] = [0, 9, 5]
  const sum = (start + end) * length
  return sum - numbers.reduce((acc, val) => acc + val, 0)
}
