// https://school.programmers.co.kr/learn/courses/30/lessons/17677
function solution(record) {
  const nickname = {}
  record.forEach((item) => {
    const [type, uid, name] = item.split(' ')

    if (type === 'Change' || type === 'Enter') {
      nickname[uid] = name
    }
  })

  return record
    .filter((item) => item.indexOf('Change') < 0)
    .map((item) => {
      const [type, uid, name] = item.split(' ')
      const currentNickname = nickname[uid] ?? name
      if (type === 'Enter') {
        return `${currentNickname}님이 들어왔습니다.`
      } else {
        return `${currentNickname}님이 나갔습니다.`
      }
    })
}

function runTests() {
  const testCases = [
    // ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
    {
      input: [
        [
          'Enter uid1234 Muzi',
          'Enter uid4567 Prodo',
          'Leave uid1234',
          'Enter uid1234 Prodo',
          'Change uid4567 Ryan',
        ],
      ],
      expected: [
        'Prodo님이 들어왔습니다.',
        'Ryan님이 들어왔습니다.',
        'Prodo님이 나갔습니다.',
        'Prodo님이 들어왔습니다.',
      ],
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
