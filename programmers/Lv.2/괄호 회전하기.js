// https://school.programmers.co.kr/learn/courses/30/lessons/76502
function solution(s) {
  let str = s
  let cnt = 0
  for (let i = 0; i < s.length; i++) {
    str = s.slice(i) + s.slice(0, i)

    const stack = []
    let idx = 0
    while (idx < str.length) {
      const top = stack[stack.length - 1]

      if (top === '(' && str[idx] === ')') {
        stack.pop()
      } else if (top === '{' && str[idx] === '}') {
        stack.pop()
      } else if (top === '[' && str[idx] === ']') {
        stack.pop()
      } else {
        stack.push(str[idx])
      }

      idx++
    }

    if (stack.length === 0) {
      cnt++
    }
  }
  return cnt
}

function runTests() {
  const testCases = [
    //"[](){}"	3
    // "}]()[{"	2
    // "[)(]"	0
    // "}}}"	0
    {
      input: ['[](){}'],
      expected: 3,
    },
    {
      input: ['}]()[{'],
      expected: 2,
    },
    {
      input: ['[)(]'],
      expected: 0,
    },
    {
      input: ['}}}'],
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
