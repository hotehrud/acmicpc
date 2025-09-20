// https://school.programmers.co.kr/learn/courses/30/lessons/135807
function solution(arrayA, arrayB) {
  const gcd = (a, b) => {
    while (b !== 0) {
      const temp = b
      b = a % b
      a = temp
    }
    return a
  }

  const A = arrayA.reduce((acc, val) => {
    return gcd(acc, val)
  }, 0)
  const B = arrayB.reduce((acc, val) => {
    return gcd(acc, val)
  }, 0)

  const isA = arrayA.every((item) => item % B !== 0)
  const isB = arrayB.every((item) => item % A !== 0)

  if ((isA && B > 1) || (isB && A > 1)) {
    return Math.max(A, B)
  }

  return 0
}

function runTests() {
  const testCases = [
    // [10, 17]	[5, 20]	0
    // [10, 20]	[5, 17]	10
    // [14, 35, 119]	[18, 30, 102]	7
    {
      input: [
        [10, 17],
        [5, 20],
      ],
      expected: 0,
    },
    {
      input: [
        [10, 20],
        [5, 17],
      ],
      expected: 10,
    },
    {
      input: [
        [14, 35, 119],
        [18, 30, 102],
      ],
      expected: 7,
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
