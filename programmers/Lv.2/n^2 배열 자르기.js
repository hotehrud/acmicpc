// https://school.programmers.co.kr/learn/courses/30/lessons/87390
function solution(n, left, right) {
  // 1 2 3 4
  // 2 2 3 4
  // 3 3 3 4
  // 4 4 4 4
  let arr = []
  for (let i = left; i <= right; i++) {
    const row = Math.floor(i / n)
    const col = i % n
    arr.push(Math.max(row + 1, col + 1))
  }

  return arr

  // let arr = []
  // for (let i = 0; i < n; i++) {
  //   for (let j = 0; j < n; j++) {
  //     const idx = i * n + j
  //     if (left <= idx && idx <= right) {
  //       if (j < i) {
  //         arr.push(i + 1)
  //       } else {
  //         arr.push(j + 1)
  //       }
  //     }
  //   }
  // }
  // return arr
  // const arr = Array.from({ length: n }, () => Array(n).fill(0))
  // for (let i = 0; i < n; i++) {
  //   for (let j = 0; j < n; j++) {
  //     if (j < i) {
  //       arr[i][j] = i + 1
  //     } else {
  //       arr[i][j] = j + 1
  //     }
  //   }
  // }
  // return arr.flat().slice(left, right + 1)
}

function runTests() {
  const testCases = [
    //3	2	5	[3,2,2,3]
    // 4	7	14	[4,3,3,3,4,4,4,4]
    {
      input: [3, 2, 5],
      expected: [3, 2, 2, 3],
    },
    {
      input: [4, 7, 14],
      expected: [4, 3, 3, 3, 4, 4, 4, 4],
    },
    {
      input: [1, 0, 0],
      expected: [1],
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
