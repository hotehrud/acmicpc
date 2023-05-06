// https://school.programmers.co.kr/learn/courses/30/lessons/131128
// 본인 풀이
function solution(X, Y) {
  const x = Array(10).fill(0)
  const y = Array(10).fill(0)
  let str = ''

  for(let i = 9; i >= 0; i--) {
    x[i] = X.split(i).length - 1
    y[i] = Y.split(i).length - 1
    const min = Math.min(y[i], x[i])
    str += min > 0 ? String(i).repeat(min) : ''
  }
  if (str[0] === '0') {
    return '0'
  }
  return !str ? "-1" : str
}

// 다른 사람의 풀이
function solution(X, Y) {
  let result = '';
  const numObj = {};

  for (const char of X) {
    numObj[char] = (numObj[char] || 0) + 1;
  }

  for (const char of Y) {
    if (!numObj[char]) continue;
    result += char;
    numObj[char]--;
  }

  if (result === '') return '-1';
  if (+result === 0) return '0';
  return [...result]
    .map((num) => +num)
    .sort((a, b) => b - a)
    .join('');
}