// https://school.programmers.co.kr/learn/courses/30/lessons/120862
// 본인 풀이
function solution(numbers) {
  numbers.sort((a, b) => a - b)
  if (numbers.length === 2) {
    return numbers.pop() * numbers.pop()
  } else {
    return Math.max(
      numbers[numbers.length - 1] * numbers[numbers.length - 2],
      numbers[0] * numbers[1],
    )
  }
}

// 다른 사람의 풀이
function solution(numbers) {
  numbers.sort((a, b) => a - b);
  return Math.max(numbers[0]*numbers[1], numbers[numbers.length-1]*numbers[numbers.length-2]);
}