// https://school.programmers.co.kr/learn/courses/30/lessons/120882
// 본인 풀이 - 점수들을 내림차순으로 정렬하고 indexOf 로 나오는 값이 공동 등수를 반영한 값과 일치함
function solution(score) {
  const scoreList = score.map(item => item[0] + item[1])
  const sumDesc = [...scoreList].sort((a, b) => b - a)
  return scoreList.map(item => sumDesc.indexOf(item) + 1)
}

// 다른 사람의 풀이 - 본인보다 점수가 높은 사람 수 + 1
function solution(score) {
  return score.map((el) => {
    return (
      score.filter((v) => (v[0] + v[1]) / 2 > (el[0] + el[1]) / 2).length + 1
    );
  });
}