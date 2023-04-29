// https://school.programmers.co.kr/learn/courses/30/lessons/120841
// 본인 풀이
function solution(dot) {
  const [x, y] = dot
  const directions = [[2, 2], [-2, 2], [-2, -2], [2, -2]]
  let index = 0
  while(index < directions.length) {
    const [dx, dy] = directions[index]
    if (x * dx > x && y * dy > y) {
      break
    }
    ++index
  }

  return index + 1;
}

// 다른 사람의 풀이 - x 의 부호로 한번 분할한 후, x*y 의 부호로 판단
function solution(dot) {
  const [num,num2] = dot;
  const check = num * num2 > 0;
  return num > 0 ? (check ? 1 : 4) : (check ? 3 : 2);
}
