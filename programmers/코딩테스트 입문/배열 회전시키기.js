// https://school.programmers.co.kr/learn/courses/30/lessons/120844
// 본인 풀이
function solution(numbers, direction) {
  if (direction === 'left') {
    numbers.push(numbers.shift())
  } else {
    numbers.unshift(numbers.pop())
  }
  return numbers
}
