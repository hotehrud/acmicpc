// https://school.programmers.co.kr/learn/courses/30/lessons/17680
function solution(cacheSize, cities) {
  const queue = []
  let total = 0

  for (let i = 0; i < cities.length; i++) {
    const city = cities[i].toLowerCase()

    if (queue.includes(city)) {
      total += 1
      queue.splice(queue.indexOf(city), 1)
    } else {
      total += 5
    }

    queue.push(city)

    if (queue.length > cacheSize) {
      queue.shift()
    }
  }
  return total
}

function runTests() {
  const testCases = [
    // 3	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	50
    // 3	["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	21
    // 2	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	60
    // 5	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	52
    // 2	["Jeju", "Pangyo", "NewYork", "newyork"]	16
    // 0	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	25
    {
      input: [3, ['Jeju', 'Jeju', 'Jeju', 'Jeju', 'LA', 'LA', 'LA', 'Jeju']],
      expected: 16,
    },
    {
      input: [
        3,
        [
          'Jeju',
          'Pangyo',
          'Seoul',
          'NewYork',
          'LA',
          'Jeju',
          'Pangyo',
          'Seoul',
          'NewYork',
          'LA',
        ],
      ],
      expected: 50,
    },
    {
      input: [
        3,
        [
          'Jeju',
          'Pangyo',
          'Seoul',
          'Jeju',
          'Pangyo',
          'Seoul',
          'Jeju',
          'Pangyo',
          'Seoul',
        ],
      ],
      expected: 21,
    },
    {
      input: [
        2,
        [
          'Jeju',
          'Pangyo',
          'Seoul',
          'NewYork',
          'LA',
          'SanFrancisco',
          'Seoul',
          'Rome',
          'Paris',
          'Jeju',
          'NewYork',
          'Rome',
        ],
      ],
      expected: 60,
    },
    {
      input: [
        5,
        [
          'Jeju',
          'Pangyo',
          'Seoul',
          'NewYork',
          'LA',
          'SanFrancisco',
          'Seoul',
          'Rome',
          'Paris',
          'Jeju',
          'NewYork',
          'Rome',
        ],
      ],
      expected: 52,
    },
    {
      input: [5, ['Jeju', 'Pangyo', 'NewYork', 'newyork']],
      expected: 16,
    },
    {
      input: [5, ['Jeju', 'Pangyo', 'Seoul', 'NewYork', 'LA']],
      expected: 25,
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
