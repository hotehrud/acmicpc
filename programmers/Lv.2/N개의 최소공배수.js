// https://school.programmers.co.kr/learn/courses/30/lessons/12953
function solution(arr) {
  const items = [...arr.sort((a,b) => a-b)]
  const max = items[items.length - 1]
  let idx = 1
  let current = 0

  while (true) {
    current = max * idx
    let flag = true

    for(let i = 0; i < items.length; i++) {
      if (current % items[i] !== 0) {
        flag = false
        break;
      }
    }

    if (flag) {
      return current;
    }

    idx++
  }
}

function runTests() {
  const testCases = [
    { input: [[2,6,8,14]], expected: 168 },
    { input: [[1,2,3]], expected: 6 },
  ];

  testCases.forEach((test, i) => {
    const result = solution(...test.input);
    const passed = result === test.expected;
    console.log(`Test ${i + 1}: ${passed ? '✅' : '❌'}`);
    if (!passed) {
      console.log(`  Expected: ${test.expected}, Got: ${result}`);
    }
  });
}

runTests();
