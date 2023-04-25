// https://school.programmers.co.kr/learn/courses/30/lessons/120853
// 본인 풀이
function solution(s) {
  const items = s.split(' ')
  return items.reduce((acc, val, index) => {
    if (val === 'Z') {
      return acc - Number(items[index - 1])
    }
    return acc + Number(val)
  }, 0)
}

// 다른 사람의 풀이 - 스택
function solution(s) {
  const stack = []

  s.split(' ').forEach((target) => {
    if(target === 'Z') stack.pop();
    else stack.push(+target)
  })

  return stack.length ? stack.reduce((pre, cur) => pre + cur) : 0;
}