// https://school.programmers.co.kr/learn/courses/30/lessons/87946
function solution(k, dungeons) {
  let max = 0

  const dfs = (k, cnt, visited) => {
    max = Math.max(max, cnt)

    for (let i = 0; i < dungeons.length; i++) {
      if (visited[i]) {
        continue
      }
      const [min, val] = dungeons[i]

      if (k >= min) {
        visited[i] = true
        dfs(k - val, cnt + 1, visited)
        visited[i] = false
      }
    }
  }

  dfs(k, 0, [])

  return max
}

function runTests() {
  const testCases = [
    //80	[[80,20],[50,40],[30,10]]	3
    {
      input: [
        80,
        [
          [80, 20],
          [50, 40],
          [30, 10],
        ],
      ],
      expected: 3,
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
