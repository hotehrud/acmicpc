// https://school.programmers.co.kr/learn/courses/30/lessons/42746
function solution(numbers) {
  const ans = [
    ...numbers.sort(
      (a, b) => Number(String(b) + String(a)) - Number(String(a) + String(b)),
    ),
  ].join('')
  return Number(ans) === 0 ? '0' : ans
}

function runTests() {
  const testCases = [
    // [6, 10, 2]	"6210"
    // [3, 30, 34, 5, 9]	"9534330"
    {
      input: [[9, 91, 912, 998, 9129]],
      expected: '9998919129912',
    },
    {
      input: [[6, 10, 2]],
      expected: '6210',
    },
    {
      input: [[3, 30, 34, 5, 9]],
      expected: '9534330',
    },
    {
      input: [[0, 0, 0]],
      expected: '0',
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
