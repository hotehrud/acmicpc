// https://school.programmers.co.kr/learn/courses/30/lessons/12941
function solution(A, B) {
  const a = [...A.sort((a, b) => a - b)]
  const b = [...B.sort((a, b) => b - a)]
  const sum = Array(a.length).fill(0);

  return sum.reduce((acc, val, idx) => {
    return acc + a[idx] * b[idx]
  }, 0)
}

function runTests() {
  const testCases = [
    { input: [[1, 4, 2], [5, 4, 4]], expected: 29 },
    { input: [[1, 2], [3, 4]], expected: 10 },
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
