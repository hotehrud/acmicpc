// https://school.programmers.co.kr/learn/courses/30/lessons/42885
function solution(str1, str2) {
  let splitStr1 = str1.toUpperCase().split('')
  let item1 = []
  for (let i = 0; i < splitStr1.length - 1; i++) {
    const str = splitStr1[i] + splitStr1[i + 1]
    if (/^[a-zA-Z]+$/.test(str)) {
      item1.push(str)
    }
  }

  let splitStr2 = str2.toUpperCase().split('')
  let item2 = []
  for (let i = 0; i < splitStr2.length - 1; i++) {
    const str = splitStr2[i] + splitStr2[i + 1]
    if (/^[a-zA-Z]+$/.test(str)) {
      item2.push(str)
    }
  }

  const count1 = {}
  const count2 = {}

  item1.forEach((item) => (count1[item] = (count1[item] ?? 0) + 1))
  item2.forEach((item) => (count2[item] = (count2[item] ?? 0) + 1))

  const allKeys = [...new Set([...Object.keys(count1), ...Object.keys(count2)])]

  const union = []
  allKeys.forEach((key) => {
    Array.from({
      length: Math.max(count1[key] ?? 0, count2[key] ?? 0),
    }).forEach(() => {
      union.push(key)
    })
  })
  const intersection = []
  allKeys.forEach((key) => {
    Array.from({
      length: Math.min(count1[key] ?? 0, count2[key] ?? 0),
    }).forEach(() => {
      intersection.push(key)
    })
  })

  return Math.floor(
    (union.length === 0 ? 1 : intersection.length / union.length) * 65536,
  )
}

function runTests() {
  const testCases = [
    // FRANCE	french	16384
    // handshake	shake hands	65536
    // aa1+aa2	AAAA12	43690
    // E=M*C^2	e=m*c^2	65536
    {
      input: ['FRANCE', 'french'],
      expected: 16384,
    },
    {
      input: ['handshake', 'shake hands'],
      expected: 65536,
    },
    {
      input: ['aa1+aa2', 'AAAA12'],
      expected: 43690,
    },
    {
      input: ['E=M*C^2', 'e=m*c^2'],
      expected: 65536,
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
