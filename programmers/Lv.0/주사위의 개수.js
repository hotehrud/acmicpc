// https://school.programmers.co.kr/learn/courses/30/lessons/120845
// 본인 풀이
function solution(box, n) {
  const [x, y, z] = box
  return Math.floor(x / n) * Math.floor(y / n) * Math.floor(z / n)
}

// 다른 사람의 풀이
function solution(box, n) {
  return box.reduce((acc,v) => acc * Math.floor(v / n), 1);
}