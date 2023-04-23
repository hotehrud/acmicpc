// https://school.programmers.co.kr/learn/courses/30/lessons/120880
// 본인 풀이 - pivot, left, right 활용
function solution(numlist, n) {
  numlist.push(n)
  numlist.sort((a, b) => a - b)

  const pivot = numlist.findIndex(item => item === n)
  let left = pivot - 1
  let right = pivot + 1
  let result = []

  while(left >= 0 && right <= numlist.length) {
    if (Math.abs(n - numlist[left]) >= Math.abs(n - numlist[right])) {
      result.push(numlist[right++])
    } else {
      result.push(numlist[left--])
    }
  }

  while(left > 0) {
    result.push(numlist[left--])
  }
  while(right < numlist.length) {
    result.push(numlist[right++])
  }

  return result
}

// 다른 사람의 풀이 - sort 활용
function solution(numlist, n) {
  return numlist.sort((a, b) => Math.abs(a - n) - Math.abs(b - n) || b - a);
}