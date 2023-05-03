// https://school.programmers.co.kr/learn/courses/30/lessons/135808
// 본인 풀이
function solution(k, m, score) {
  const sortedScore = [...score].sort((a, b) => b - a)
  let answer = 0

  for(let i = m - 1; i <= score.length - 1; i += m) {
    answer += sortedScore[i] * m
  }

  return answer
}

// 다른 사람의 풀이 - 정렬한 후, m 개 못 채우는 갯수 미리 제외 시키기
function solution(k, m, score) {
  let answer = 0;
  const sortedScore = score.slice().sort((a, b) => a - b).slice(score.length % m);
  for (let i = 0; i < sortedScore.length; i += m) {
    answer += sortedScore[i] * m;
  }
  return answer;
}