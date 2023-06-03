// https://school.programmers.co.kr/learn/courses/30/lessons/12915
// 본인 풀이
function solution(strings, n) {
  return strings.sort((a, b) => {
    if (a[n] < b[n]) {
      return -1
    } else if (a[n] === b[n]) {
      return a < b ? -1 : 1
    } else {
      return 1
    }
  });
}

// 다른 사람의 풀이
function solution(strings, n) {
  return strings.sort((s1, s2) => s1[n] === s2[n] ? s1.localeCompare(s2) : s1[n].localeCompare(s2[n]));
}