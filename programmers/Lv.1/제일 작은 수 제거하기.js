// https://school.programmers.co.kr/learn/courses/30/lessons/12935
// 본인 풀이
function solution(arr) {
  const min = Math.min(...arr)
  const filtered = [...arr].filter(item => item !== min)
  return filtered.length === 0 ? [-1] : filtered
}

// 다른 사람의 풀이
function solution(arr) {
  arr.splice(arr.indexOf(Math.min(...arr)),1);
  if(arr.length<1)return[-1];
  return arr;
}
