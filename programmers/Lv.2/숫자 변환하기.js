// https://school.programmers.co.kr/learn/courses/30/lessons/154538
function solution(x, y, n) {
  const queue = [[y, 0]]
  const visited = {}

  while (queue.length > 0) {
    const [current, cnt] = queue.shift()
    const temp = []

    if (current === x) {
      return cnt
    }

    if (current - n > 0) {
      temp.push(current - n)
    }
    if (current % 2 === 0) {
      temp.push(current / 2)
    }
    if (current % 3 === 0) {
      temp.push(current / 3)
    }

    temp.forEach((item) => {
      if (!visited[item]) {
        queue.push([item, cnt + 1])
        visited[item] = true
      }
    })
  }

  return -1

  // let ans = Number.MAX_VALUE
  // const dfs = (val, cnt) => {
  //   if (val === y) {
  //     ans = Math.min(cnt, ans)
  //     return
  //   }
  //   if (val > y || cnt > ans) {
  //     return
  //   }
  //
  //   if (cnt > 1000000) {
  //     return
  //   }
  //
  //   dfs(n + val, cnt + 1)
  //   dfs(val * 2, cnt + 1)
  //   dfs(val * 3, cnt + 1)
  // }
  //
  // dfs(x, 0)
  // return ans !== Number.MAX_VALUE ? ans : -1
}

function runTests() {
  const testCases = [
    // 10	40	5	2
    // 10	40	30	1
    // 2	5	4	-1
    // {
    //   input: [10, 40, 5],
    //   expected: 2,
    // },
    // {
    //   input: [10, 40, 30],
    //   expected: 1,
    // },
    // {
    //   input: [2, 5, 4],
    //   expected: -1,
    // },
    {
      input: [2, 999999, 1],
      expected: -1,
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
