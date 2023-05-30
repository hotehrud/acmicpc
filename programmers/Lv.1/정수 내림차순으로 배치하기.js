// https://school.programmers.co.kr/learn/courses/30/lessons/12933
// 본인 풀이
function solution(n) {
  return +(String(n).split('').sort((a, b) => b - a).join(''));
}

// 다른 사람의 풀이
function solution(n) {
  const newN = n + "";
  const newArr = newN
    .split("")
    .sort()
    .reverse()
    .join("");

  return +newArr;
}