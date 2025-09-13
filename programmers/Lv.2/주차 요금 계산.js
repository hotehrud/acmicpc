// https://school.programmers.co.kr/learn/courses/30/lessons/92341
function solution(fees, records) {
  function getMinutesDifference(time1, time2) {
    const [hours1, minutes1] = time1.split(':').map(Number)
    const [hours2, minutes2] = time2.split(':').map(Number)

    const totalMinutes1 = hours1 * 60 + minutes1
    const totalMinutes2 = hours2 * 60 + minutes2

    return Math.abs(totalMinutes1 - totalMinutes2)
  }

  const [baseTime, baseFee, unitMin, unitFee] = fees
  const carMap = new Map()

  records.forEach((record) => {
    const [time, num] = record.split(' ')
    carMap.set(num, [...(carMap.get(num) ?? []), time])
  })
  carMap.forEach((value, key) => {
    let sum = 0
    while (value.length > 0) {
      const enter = value.shift()
      const exit = value.length > 0 ? value.shift() : '23:59'
      const min = getMinutesDifference(enter, exit)
      sum += min
    }
    carMap.set(
      key,
      sum > baseTime
        ? baseFee + Math.ceil((sum - baseTime) / unitMin) * unitFee
        : baseFee,
    )
  })
  return [...carMap.entries()]
    .sort(([a], [b]) => Number(a) - Number(b))
    .map((item) => item[1])
}

function runTests() {
  const testCases = [
    // [180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	[14600, 34400, 5000]
    // [120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]	[0, 591]
    // [1, 461, 1, 10]	["00:00 1234 IN"]	[14841]
    {
      input: [
        [180, 5000, 10, 600],
        [
          '05:34 5961 IN',
          '06:00 0000 IN',
          '06:34 0000 OUT',
          '07:59 5961 OUT',
          '07:59 0148 IN',
          '18:59 0000 IN',
          '19:09 0148 OUT',
          '22:59 5961 IN',
          '23:00 5961 OUT',
        ],
      ],
      expected: [14600, 34400, 5000],
    },
    {
      input: [
        [120, 0, 60, 591],
        [
          '16:00 3961 IN',
          '16:00 0202 IN',
          '18:00 3961 OUT',
          '18:00 0202 OUT',
          '23:58 3961 IN',
        ],
      ],
      expected: [0, 591],
    },
    {
      input: [[1, 461, 1, 10], ['00:00 1234 IN']],
      expected: [14841],
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
