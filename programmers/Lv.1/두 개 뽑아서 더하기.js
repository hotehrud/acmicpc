// https://school.programmers.co.kr/learn/courses/30/lessons/68644
// 본인 풀이
function solution(numbers) {
  const sortedList = numbers
  const list = new Set()

  for(let i = 0; i < sortedList.length - 1; i++) {
    for(let j = i + 1; j < sortedList.length; j++) {
      list.add(sortedList[i] + sortedList[j])
    }
  }

  return [...list].sort((a, b) => a - b)
}