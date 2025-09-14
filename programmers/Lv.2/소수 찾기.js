// https://school.programmers.co.kr/learn/courses/30/lessons/42839
function solution(numbers) {
  const items = new Set()
  const visited = Array(numbers.length).fill(false)

  const isPrime = (num) => {
    if (num < 2) {
      return false
    }

    for (let i = 2; i <= Math.sqrt(num); i++) {
      if (num % i === 0) {
        return false
      }
    }
    return true
  }

  const dfs = (idx, val) => {
    if (idx > numbers.length) {
      return
    }

    if (isPrime(+val)) {
      items.add(+val)
    }

    for (let i = 0; i < numbers.length; i++) {
      const newValue = `${val}${numbers[i]}`
      if (!visited[i]) {
        visited[i] = true
        dfs(idx + 1, newValue)
        visited[i] = false
      }
    }
  }

  dfs(0, '')

  return items.size
}

function runTests() {
  const testCases = [
    // "17"	3
    // "011"	2
    // {
    //   input: ['17'],
    //   expected: 3,
    // },
    {
      input: ['1234567'],
      expected: 3,
    },
    {
      input: ['011'],
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
