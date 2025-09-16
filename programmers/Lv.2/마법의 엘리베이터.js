// https://school.programmers.co.kr/learn/courses/30/lessons/148653
function solution(storey) {
  let ans = 0

  while (storey > 0) {
    const lastDigit = storey % 10
    const nextDigit = Math.floor(storey / 10) % 10

    if (lastDigit > 5 || (lastDigit === 5 && nextDigit >= 5)) {
      ans += 10 - lastDigit
      storey = Math.floor(storey / 10) + 1
    } else {
      ans += lastDigit
      storey = Math.floor(storey / 10)
    }
  }

  return ans
}

function runTests() {
  const testCases = [
    // 16	6
    // 2554	16
    {
      input: [16],
      expected: 6,
    },
    {
      input: [2554],
      expected: 16,
    },
    {
      input: [1],
      expected: 1,
    },
    {
      input: [999],
      expected: 2,
    },
    {
      input: [15555], // 2 4 4 4 5
      expected: 19,
    },
    {
      input: [15],
      expected: 6,
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
