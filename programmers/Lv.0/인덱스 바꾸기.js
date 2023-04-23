// https://school.programmers.co.kr/learn/courses/30/lessons/120895
// 본인 풀이 - 알파벳 카운트 배열을 생성 + 아스키코드 활용
function solution(my_string, num1, num2) {
  const array = my_string.split('')
  const temp = array[num1]
  array[num1] = array[num2]
  array[num2] = temp
  return array.join('')
}