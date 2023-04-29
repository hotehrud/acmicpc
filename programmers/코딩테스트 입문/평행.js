// https://school.programmers.co.kr/learn/courses/30/lessons/120875
// 본인 풀이 - 모든 상황에 대해 두 직선의 기울기
function solution(dots) {
  const getSlope = (x1, x2, y1, y2) => {
    return (x2 - x1) / (y2 - y1)
  }
  const [[x1, y1], [x2, y2], [x3, y3], [x4, y4]] = dots

  return getSlope(x1, x2, y1, y2) === getSlope(x3, x4, y3, y4)
  || getSlope(x1, x3, y1, y3) === getSlope(x2, x4, y2, y4)
  || getSlope(x1, x4, y1, y4) === getSlope(x2, x3, y2, y3) ? 1 : 0
}