// https://school.programmers.co.kr/learn/courses/30/lessons/1844
function solution(maps) {
  const queue = []
  const dx = [-1, 0, 1, 0]
  const dy = [0, -1, 0, 1]
  const visited = Array.from({ length: maps.length }, () =>
    Array(maps[0].length).fill(false),
  )
  let cnt = 1
  let success = false

  queue.push([0, 0, 1])
  visited[0][0] = true

  while (queue.length > 0) {
    const [y, x, c] = queue.shift()

    if (y === maps.length - 1 && x === maps[0].length - 1) {
      success = true
      cnt = c
      break
    }

    for (let i = 0; i < 4; i++) {
      const nx = x + dx[i]
      const ny = y + dy[i]

      if (
        nx > -1 &&
        ny > -1 &&
        nx < maps[0].length &&
        ny < maps.length &&
        maps[ny][nx] === 1 &&
        !visited[ny][nx]
      ) {
        visited[ny][nx] = true
        queue.push([ny, nx, c + 1])
      }
    }
  }

  return success ? cnt : -1

  // const dx = [-1, 0, 1, 0]
  // const dy = [0, -1, 0, 1]
  // const visited = Array.from({ length: maps.length }, () =>
  //   Array(maps[0].length).fill(false),
  // )
  // let min = Number.MAX_VALUE
  //
  // const dfs = (y, x, cnt, visited) => {
  //   if (visited[y][x]) {
  //     return
  //   }
  //   if (min < cnt) {
  //     return
  //   }
  //   if (y === maps.length - 1 && x === maps[0].length - 1) {
  //     min = Math.min(cnt, min)
  //     return
  //   }
  //   visited[y][x] = true
  //
  //   for (let i = 0; i < 4; i++) {
  //     const nx = x + dx[i]
  //     const ny = y + dy[i]
  //
  //     if (nx > -1 && ny > -1 && nx < maps[0].length && ny < maps.length) {
  //       if (maps[ny][nx] === 1) {
  //         // console.log(ny, nx)
  //         dfs(ny, nx, cnt + 1, visited)
  //       }
  //     }
  //   }
  //
  //   visited[y][x] = false
  // }
  //
  // dfs(0, 0, 1, visited)
  // return min === Number.MAX_VALUE ? -1 : min
}

function runTests() {
  const testCases = [
    // [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]] 11
    // [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
    {
      input: [
        [
          [1, 0, 1, 1, 1],
          [1, 0, 1, 0, 1],
          [1, 0, 1, 1, 1],
          [1, 1, 1, 0, 1],
          [0, 0, 0, 0, 1],
        ],
      ],
      expected: 11,
    },
    {
      input: [
        [
          [1, 0, 1, 1, 1],
          [1, 0, 1, 0, 1],
          [1, 0, 1, 1, 1],
          [1, 1, 1, 0, 0],
          [0, 0, 0, 0, 1],
        ],
      ],
      expected: -1,
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
