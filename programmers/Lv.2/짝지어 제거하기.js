// https://school.programmers.co.kr/learn/courses/30/lessons/12973
function solution(s) {
  let stack = []
  let idx = 1
  let next = s[0]

  stack.push(next)

  while(idx < s.length) {
    const top = stack[stack.length - 1]
    let next = s[idx]
    if (top === next) {
      stack.pop()
    } else {
      stack.push(next)
    }
    ++idx
  }

  return stack.length === 0 ? 1 : 0
}

function runTests() {
  const testCases = [
    { input: ['baabaa'], expected: [1] },
    { input: ['cdcd'], expected: [0] },
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
