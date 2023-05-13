// https://school.programmers.co.kr/learn/courses/30/lessons/67256
// 본인 풀이
function solution(numbers, hand) {
  const handCode = {
    right: 'R',
    left: 'L',
  }
  const finger = {
    L: [3, 0],
    R: [3, 2],
  }
  const keypad = [[3, 1]]
  let ans = ''

  for (let i = 1; i <= 9; i++) {
    keypad.push([Math.ceil(i / 3) - 1, (i - 1) % 3])
  }

  numbers.forEach((value) => {
    const [ny, nx] = keypad[value]
    let direction = ''
    if ([1, 4, 7].includes(value)) {
      direction = 'L'
    } else if ([3, 6, 9].includes(value)) {
      direction = 'R'
    } else {
      const [ly, lx] = finger.L
      const [ry, rx] = finger.R
      const [diffLeft, diffRight] = [
        Math.abs(ly - ny) + Math.abs(lx - nx),
        Math.abs(ry - ny) + Math.abs(rx - nx),
      ]

      if (diffLeft < diffRight) {
        direction = 'L'
      } else if (diffLeft > diffRight) {
        direction = 'R'
      } else {
        direction = handCode[hand]
      }
    }
    finger[direction] = [ny, nx]
    ans += direction
  })
  return ans
}

// 다른 사람의 풀이
function solution(numbers, hand) {
  hand = hand[0] === "r" ? "R" : "L"
  let position = [1, 4, 4, 4, 3, 3, 3, 2, 2, 2]
  let h = { L: [1, 1], R: [1, 1] }
  return numbers.map(x => {
    if (/[147]/.test(x)) {
      h.L = [position[x], 1]
      return "L"
    }
    if (/[369]/.test(x)) {
      h.R = [position[x], 1]
      return "R"
    }
    let distL = Math.abs(position[x] - h.L[0]) + h.L[1]
    let distR = Math.abs(position[x] - h.R[0]) + h.R[1]
    if (distL === distR) {
      h[hand] = [position[x], 0]
      return hand
    }
    if (distL < distR) {
      h.L = [position[x], 0]
      return "L"
    }
    h.R = [position[x], 0]
    return "R"
  }).join("")
}
