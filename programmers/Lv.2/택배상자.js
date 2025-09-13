// https://school.programmers.co.kr/learn/courses/30/lessons/131704
function solution(order) {
  const max = order.length
  const stack = []
  let currentIdx = 0

  for (let i = 1; i <= max; i++) {
    if (stack[stack.length - 1] === order[currentIdx]) {
      currentIdx++
      stack.pop()
    }
    if (i === order[currentIdx]) {
      currentIdx++
    } else {
      stack.push(i)
    }
  }

  // while (stack.length > 0) {
  //   const target = stack.pop()
  //   if (target === order[currentIdx]) {
  //     currentIdx++
  //   } else {
  //     break
  //   }
  // }

  return currentIdx
}

function runTests() {
  const testCases = [
    // 4, 3, 1, 2, 5]	2
    // [5, 4, 3, 2, 1]	5
    {
      input: [[4, 3, 1, 2, 5]],
      expected: 2,
    },
    {
      input: [[5, 4, 3, 2, 1]],
      expected: 5,
    },
    {
      input: [[1, 2, 4, 3]],
      expected: 4,
    },
    {
      input: [[1, 2, 4, 3, 5]],
      expected: 5,
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
