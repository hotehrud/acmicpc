// https://school.programmers.co.kr/learn/courses/30/lessons/120829
// 본인 풀이
function solution(angle) {
  if (angle / 90 === 1) {
    return 2
  } else if (angle / 90 === 2) {
    return 4
  } else if (angle < 90) {
    return 1
  } else {
    return 3
  }
}

// 다른 사람의 풀이
function solution(angle) {
  return [0, 90, 91, 180].filter(x => angle>=x).length;
}