// https://school.programmers.co.kr/learn/courses/30/lessons/120861
// 본인 풀이
function solution(keyinput, board) {
  const direction = {
    up: [0, 1],
    down: [0, -1],
    left: [-1, 0],
    right: [1, 0],
  }
  const [w, h] = board
  const halfX = Math.floor(w / 2)
  const halfY = Math.floor(h / 2)
  let x = halfX
  let y = halfY

  keyinput.forEach(key => {
    const [mx, my] = direction[key]
    const nextX = x + mx
    const nextY = y + my
    if (nextX > - 1 && nextY > -1 && nextX < w && nextY < h) {
      x = nextX
      y = nextY
    }
  })

  return [x - halfX, y - halfY]
}