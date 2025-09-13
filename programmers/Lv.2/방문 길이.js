// https://school.programmers.co.kr/learn/courses/30/lessons/49994
function solution(dirs) {
  const direction = {
    U: [-1, 0],
    D: [1, 0],
    L: [0, -1],
    R: [0, 1],
  }

  const set = new Set()
  let x = 5
  let y = 5
  for (let i = 0; i < dirs.length; i++) {
    const dir = dirs[i]
    const [moveY, moveX] = direction[dir]
    const nextX = x + moveX
    const nextY = y + moveY

    if (nextX > -1 && nextX < 11 && nextY > -1 && nextY < 11) {
      set.add([`${nextY},${nextX}`, `${y},${x}`].sort().join(','))
      x = nextX
      y = nextY
    }
  }

  return set.size
}

function runTests() {
  const testCases = [
    // "ULURRDLLU"	7
    // "LULLLLLLU"	7
    {
      input: ['ULURRDLLU'],
      expected: 7,
    },
    {
      input: ['LULLLLLLU'],
      expected: 7,
    },
    {
      input: ['ULURRDLD'],
      expected: 7,
    },
    {
      input: ['UD'],
      expected: 1,
    },
  ]

  testCases.forEach((test, i) => {
    const result = solution(...test.input)
    const passed = result === test.expected
    console.log(`Test ${i + 1}: ${passed ? '✅' : '❌'}`)
    if (!passed) {
      console.log(`  Expected: ${test.expected}, Got: ${result}`)
    }
  })
}

runTests()
