// https://school.programmers.co.kr/learn/courses/30/lessons/42586
function solution(progresses, speeds) {
  const items = progresses.map((item, idx) => {
    return Math.ceil((100 - item) / speeds[idx])
  })
  const queue = []
  while (items.length > 0) {
    const first = items.shift()
    let nextDeployIndex = items.findIndex((item) => item > first)
    if (nextDeployIndex > -1) {
      items.splice(0, nextDeployIndex)
      queue.push(nextDeployIndex + 1)
    } else {
      queue.push(1 + items.length)
      break
    }
  }

  return queue
}

function runTests() {
  const testCases = [
    //[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
    // {
    //   input: [
    //     [93, 30, 55],
    //     [1, 30, 5],
    //   ],
    //   expected: [2, 1],
    // },
    {
      input: [
        [95, 90, 99, 99, 80, 99],
        [1, 1, 1, 1, 1, 1],
      ],
      expected: [1, 3, 2],
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
