// https://school.programmers.co.kr/learn/courses/30/lessons/42587
function solution(priorities, location) {
  const items = priorities.map((item, idx) => ({
    my: idx,
    value: item,
  }))

  const queue = []
  while (items.length > 0) {
    const first = items.shift()

    const isHighPriority = items.some((item) => {
      return item.value > first.value
    })

    if (isHighPriority) {
      items.push(first)
    } else {
      queue.push(first)
    }
  }

  return queue.findIndex((item) => item.my === location) + 1

  // let targetIndex = location
  // let remove = 0
  //
  // while (priorities.length > 0) {
  //   const wait = priorities[0]
  //   const idx = priorities.findIndex((item) => item > wait)
  //
  //   if (idx > -1) {
  //     priorities.shift()
  //     priorities.push(wait)
  //
  //     if (targetIndex === 0) {
  //       targetIndex = priorities.length - 1
  //     } else {
  //       targetIndex--
  //     }
  //   } else {
  //     priorities.shift()
  //     remove++
  //
  //     if (targetIndex === 0) {
  //       break
  //     }
  //     targetIndex--
  //   }
  // }
  //
  // return remove
}

function runTests() {
  const testCases = [
    //[2, 1, 3, 2]	2	1
    // [1, 1, 9, 1, 1, 1]	0	5
    {
      input: [[2, 1, 3, 2], 2],
      expected: 1,
    },
    {
      input: [[1, 1, 9, 1, 1, 1], 0],
      expected: 5,
    },
    {
      input: [[1, 1, 9, 1, 9, 1, 1], 0],
      expected: 5,
    },
    {
      input: [[2, 2, 2, 2, 2, 9, 7, 1, 8, 3, 2], 4],
      expected: 10,
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
