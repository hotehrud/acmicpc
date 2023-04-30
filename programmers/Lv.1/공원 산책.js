// https://school.programmers.co.kr/learn/courses/30/lessons/172928
// 본인 풀이
function solution(park, routes) {
  const op = {
    N: 0,
    S: 1,
    W: 2,
    E: 3,
  }
  const directions = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
  ]
  const map = park.map((item) => item.split(''))
  const index = park.join('').indexOf('S')
  const [w, h] = [park[0].length, park.length]
  let [y, x] = [Math.floor(index / h), index % w]
  routes.forEach((route) => {
    const [direction, move] = route.split(' ')
    const [my, mx] = directions[op[direction]]
    const endX = x + mx * move
    const endY = y + my * move
    let tempX = x
    let tempY = y
    let success = true

    if (endX >= 0 && endX < w && endY >= 0 && endY < h) {
      while (tempX !== endX || tempY !== endY) {
        if (map[tempY + my][tempX + mx] === 'X') {
          success = false
          break
        }
        tempX += mx
        tempY += my
      }
    }
    if (success) {
      x = tempX
      y = tempY
    }
  })
  return [y, x]
}

// 다른 사람의 풀이 - 맵을 2차원 배열로 만들 필요없이 string 은 인덱스로 접근 가능. + 배열 길이를 넘는 인덱스 접근 시 에러가 아니라 undefined
function solution(park, routes) {
  const dirs = { E: [0, 1], W: [0, -1], S: [1, 0], N: [-1, 0] };
  let [x, y] = [0, 0];
  for (let i = 0; i < park.length; i++) {
    if (park[i].includes('S')) {
      [x, y] = [i, park[i].indexOf('S')];
      break;
    }
  }

  routes.forEach((route) => {
    const [r, n] = route.split(' ');
    let [nx, ny] = [x, y];
    let cnt = 0;
    while (cnt < n) {
      [nx, ny] = [nx + dirs[r][0], ny + dirs[r][1]];
      if (!park[nx] || !park[nx][ny] || park[nx][ny] === 'X') break;
      cnt++;
    }
    if (cnt == n) [x, y] = [nx, ny];
  });
  return [x, y];
}