// https://school.programmers.co.kr/learn/courses/30/lessons/133502
// 본인 풀이
function solution(ingredient) {
  let stack = [0]
  let ans = 0
  let i = 0

  while (i < ingredient.length) {
    const top = stack[stack.length - 1]
    if (ingredient[i] === 1) {
      if (top === 3) {
        stack.pop()
        stack.pop()
        stack.pop()
        ans += 1
      } else {
        stack.push(1)
      }
    } else if (ingredient[i] === top + 1) {
      stack.push(ingredient[i])
    } else {
      stack = []
    }
    i += 1
  }
  return ans
}

// 다른 사람의 풀이
function solution(ingredient) {
  let count = 0;

  for (let i = 0; i < ingredient.length; i++) {
    if (ingredient.slice(i, i + 4).join('') === '1231') {
      count++;
      ingredient.splice(i, 4);
      i -= 3;
    }
  }

  return count;
}

function solution(ingredient) {
  let stk = [];
  let count = 0;
  for (let i = 0; i < ingredient.length; i++) {
    stk.push(ingredient[i]);
    if (
      stk[stk.length-1] === 1 &&
      stk[stk.length-2] === 3 &&
      stk[stk.length-3] === 2 &&
      stk[stk.length-4] === 1
    ) {
      count++;
      stk.splice(-4);
    }
  }
  return count;
}
