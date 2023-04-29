// https://school.programmers.co.kr/learn/courses/30/lessons/120863
// 본인 풀이
function solution(polynomial) {
  let x = 0
  let n = 0
  polynomial.replaceAll(/[+]/g, '').split('  ').forEach(value => {
    if (value.includes('x')) {
      x += Number(value.slice(0, -1)) || 1
    } else {
      n += Number(value)
    }
  })
  let result = ''
  result += x > 0 ? `${x > 1 ? x : ''}x` : ''
  result += n > 0 ? result ? ` + ${n}` : `${n}` : ''
  return result.trim()
}

// 다른 사람의 풀이 - 마지막 분리된 x 값과 상수값을 배열로 넣어서 join 을 활용할 수 있음. ['2x'].join(' + ') => 2x | ['2x', 22].join(' + ') => 2x + 22
function solution(polynomial) {
  const arr = polynomial.split(" + ");
  const xNum = arr
    .filter(n => n.includes("x"))
    .map(n => n.replace('x', '') || '1')
    .reduce((acc, cur) => acc + parseInt(cur, 10), 0);
  const num = arr
    .filter(n => !isNaN(n))
    .reduce((acc, cur) => acc + parseInt(cur, 10), 0);

  let answer = [];
  if(xNum) answer.push(`${xNum === 1 ? "" : xNum}x`);
  if(num) answer.push(num);

  return answer.join(" + ");
}