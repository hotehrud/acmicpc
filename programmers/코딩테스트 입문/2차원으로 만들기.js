// https://school.programmers.co.kr/learn/courses/30/lessons/120842
// 본인 풀이
function solution(num_list, n) {
  const answer = []
  for(let i = 0; i <= num_list.length; i += n) {
    const items = num_list.slice(i, i + n)
    if (items.length > 0) {
      answer.push(items)
    }
  }
  return answer
}

// 다른 사람의 풀이
function solution(num_list, n) {
  return Array(num_list.length / n).fill([]).map(() => num_list.splice(0, n))
}