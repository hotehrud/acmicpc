// https://school.programmers.co.kr/learn/courses/30/lessons/120812
// 본인 풀이
function solution(array) {
  const cnt = Array(1000).fill(0)

  array.forEach(value => {
    ++cnt[value]
  })

  const max = Math.max(...cnt)
  return cnt.filter(value => value === max).length === 1 ? cnt.findIndex(value => value === max) : -1
}

// 다른 사람의 풀이 - key-value 구조로 빈도 관리 => 배열로 변환하여 최빈값 다중 유무 판단
function solution(array) {
  let m = new Map();
  for (let n of array) m.set(n, (m.get(n) || 0)+1);
  m = [...m].sort((a,b)=>b[1]-a[1]);
  return m.length === 1 || m[0][1] > m[1][1] ? m[0][0] : -1;
}