// https://school.programmers.co.kr/learn/courses/30/lessons/138477
// 본인 풀이
function solution(k, score) {
  const topK = Array(k).fill(0)
  return score.map((item, idx) => {
    if (topK[k - 1] <= item) {
      topK[k - 1] = item
    }
    topK.sort((a, b) => b - a)
    return idx < k ? topK[idx] : topK[k - 1]
  })
}

// 다른 사람의 풀이
function solution(k, score) {
  const stack = []
  return score.reduce((a,c) => {
    if(stack.length < k) {
      stack.push(c)
      stack.sort((a,b) => a - b)
    }
    else {
      stack.push(c)
      stack.sort((a,b) => a - b)
      stack.shift()
    }
    a.push(stack[0])
    return a
  },[])
}