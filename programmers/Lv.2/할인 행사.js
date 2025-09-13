// https://school.programmers.co.kr/learn/courses/30/lessons/131127
function solution(want, number, discount) {
  const wantMap = want.reduce((acc, val, idx) => {
    acc[val] = number[idx]
    return acc
  }, {})
  let result = 0

  for (let i = 0; i < discount.length; i++) {
    const days = discount.slice(i, i + 10)
    const discountMap = days.reduce((acc, val) => {
      acc[val] = (acc[val] ?? 0) + 1
      return acc
    }, {})

    let isOk = true

    Object.keys(wantMap).forEach((item) => {
      if (wantMap[item] !== discountMap[item]) {
        isOk = false
      }
    })

    if (isOk) {
      result++
    }
  }
  return result
}

function runTests() {
  const testCases = [
    {
      input: [
        ['banana', 'apple', 'rice', 'pork', 'pot'],
        [3, 2, 2, 2, 1],
        [
          'chicken',
          'apple',
          'apple',
          'banana',
          'rice',
          'apple',
          'pork',
          'banana',
          'pork',
          'rice',
          'pot',
          'banana',
          'apple',
          'banana',
        ],
      ],
      expected: 3,
    },
    {
      input: [
        ['apple'],
        [10],
        [
          'banana',
          'banana',
          'banana',
          'banana',
          'banana',
          'banana',
          'banana',
          'banana',
          'banana',
          'banana',
        ],
      ],
      expected: 0,
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
