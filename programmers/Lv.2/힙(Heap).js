// https://school.programmers.co.kr/learn/courses/30/lessons/42626
// 정확성: 83.9
// 효율성: 0.0
// 합계: 83.9 / 100.0
function solution(scoville, K) {
  const binarySearch = (arr, target) => {
    let left = 0
    let right = arr.length
    let mid = 0

    while (left < right) {
      mid = Math.floor((right + left) / 2)
      if (arr[mid] < target) {
        left = mid + 1
      } else {
        right = mid
      }
    }
    return left
  }

  const items = [...scoville.sort((a, b) => a - b)]

  let cnt = 0
  while (items[0] < K && items.length > 1) {
    let first = items.shift()
    let second = items.shift()
    const n = first + second * 2
    const idx = binarySearch(items, n)

    items.splice(idx, 0, n)
    cnt++
  }
  return items[0] < K ? -1 : cnt
}

function runTests() {
  const testCases = [
    // [1, 2, 3, 9, 10, 12]	7	2
    {
      input: [[1, 2, 3, 9, 10, 12], 7],
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
