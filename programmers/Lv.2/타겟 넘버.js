// https://school.programmers.co.kr/learn/courses/30/lessons/43165
function solution(numbers, target) {
  let ans = 0

  const dfs = (idx, val) => {
    if (idx === numbers.length) {
      if (val === target) {
        ans++
      }
      return
    }

    dfs(idx + 1, val + numbers[idx])
    dfs(idx + 1, val - numbers[idx])
  }

  dfs(0, 0)
  return ans
}

function runTests() {
  const testCases = [
    //[1, 1, 1, 1, 1]	3	5
    // [4, 1, 2, 1]	4	2
    {
      input: [[1, 1, 1, 1, 1], 3],
      expected: 5,
    },
    {
      input: [[4, 1, 2, 1], 4],
      expected: 2,
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
