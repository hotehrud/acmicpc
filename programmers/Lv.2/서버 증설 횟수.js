// https://school.programmers.co.kr/learn/courses/30/lessons/389479
function solution(players, m, k) {
  let serverList = []
  let ans = 0

  for (let i = 0; i < players.length; i++) {
    const player = players[i]

    serverList = serverList.filter((item) => {
      return item + k > i
    })

    const needServerCount = Math.floor(player / m)

    if (needServerCount > serverList.length) {
      const addServerCount = needServerCount - serverList.length
      const newServerList = Array.from({ length: addServerCount }).fill(i)
      serverList = [...serverList, ...newServerList]
      ans += addServerCount
    }
  }

  return ans
}

function runTests() {
  const testCases = [
    //[0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5]	3	5	7
    // [0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0]	5	1	11
    // [0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1]	1	1	12
    {
      input: [
        [
          0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1,
          5,
        ],
        3,
        5,
      ],
      expected: 7,
    },
    {
      input: [
        [
          0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0,
          0, 0,
        ],
        5,
        1,
      ],
      expected: 11,
    },
    {
      input: [
        [
          0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0,
          1,
        ],
        1,
        1,
      ],
      expected: 12,
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
