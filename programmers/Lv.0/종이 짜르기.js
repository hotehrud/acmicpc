// https://school.programmers.co.kr/learn/courses/30/lessons/120922
// 본인 풀이 - 가로는 길이 - 1만큼 짜르고, 세로는 추가로 분리된 갯수만큼 더 잘라야함
function solution(M, N) {
  return (M - 1) + ((N - 1) * M)
}

// 다른 사람의 풀이
function solution(M, N) {
  return M*N-1;
}
