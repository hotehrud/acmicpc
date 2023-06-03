// https://school.programmers.co.kr/learn/courses/30/lessons/12910
// 본인 풀이
function solution(arr, divisor) {
  const ans = arr.filter(item => item % divisor === 0).sort((a, b) => a - b);
  return ans.length > 0 ? ans : [-1]
}