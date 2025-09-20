// https://school.programmers.co.kr/learn/courses/30/lessons/155651
function solution(book_time) {
  const time = Array.from({ length: 2410 }).fill(0)
  let max = 0

  book_time.forEach(([start, end]) => {
    const startN = Number(start.split(':').join(''))
    let endN = Number(end.split(':').join('')) + 10

    const min = Number(String(endN).slice(-2))
    if (min >= 60) {
      endN += 100 - 60
    }

    for (let i = startN; i < endN; i++) {
      if (Number(String(i).slice(2)) < 60) {
        time[i]++
        max = Math.max(time[i], max)
      }
    }
  })
  return max
}

function runTests() {
  const testCases = [
    // [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]	3
    // [["09:10", "10:10"], ["10:20", "12:20"]]	1
    // [["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]	3
    // {
    //   input: [
    //     [
    //       ['15:00', '17:00'],
    //       ['16:40', '18:20'],
    //       ['14:20', '15:20'],
    //       ['14:10', '19:20'],
    //       ['18:20', '21:20'],
    //     ],
    //   ],
    //   expected: 3,
    // },
    // {
    //   input: [
    //     [
    //       ['09:10', '10:10'],
    //       ['10:20', '12:20'],
    //     ],
    //   ],
    //   expected: 1,
    // },
    // {
    //   input: [
    //     [
    //       ['10:20', '12:30'],
    //       ['10:20', '12:30'],
    //       ['10:20', '12:30'],
    //     ],
    //   ],
    //   expected: 3,
    // },
    {
      input: [
        [
          ['09:51', '09:59'],
          ['10:08', '12:30'],
        ],
      ],
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
