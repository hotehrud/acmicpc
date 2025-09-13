// https://school.programmers.co.kr/learn/courses/30/lessons/42577
function solution(phone_book) {
  phone_book.sort()

  for (let i = 0; i < phone_book.length - 1; i++) {
    if (phone_book[i + 1].startsWith(phone_book[i])) {
      return false
    }
  }
  return true

  // const separator = ','
  // let str = phone_book.sort().join(separator)
  //
  // for (let i = 0; i < phone_book.length; i++) {
  //   const item = phone_book[i]
  //
  //   const target = `${separator}${item}`
  //   if (str.indexOf(target) > -1) {
  //     return false
  //   }
  //   str = str.slice(target.length)
  // }
  //
  // return true
}

function runTests() {
  const testCases = [
    // ["119", "97674223", "1195524421"]	false
    // ["123","456","789"]	true
    // ["12","123","1235","567","88"]	false
    {
      input: [['119', '97674223', '1195524421']],
      expected: false,
    },
    {
      input: [['123', '456', '789']],
      expected: true,
    },
    {
      input: [['12', '123', '1235', '567', '88']],
      expected: false,
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
