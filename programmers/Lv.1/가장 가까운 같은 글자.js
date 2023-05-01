// https://school.programmers.co.kr/learn/courses/30/lessons/142086
// 본인 풀이
function solution(s) {
  const map = {}
  return s.split('').map((val, idx) => {
    const index = map.hasOwnProperty(val) ? idx - map[val] : -1
    map[val] = idx
    return index
  })
}

// 다른 사람의 풀이
const solution = (s) =>
  [...s].map((char, i) => {
    const count = s.slice(0, i).lastIndexOf(char);
    return count < 0 ? count : i - count;
  });