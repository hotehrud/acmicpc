// https://school.programmers.co.kr/learn/courses/30/lessons/12945
function solution(n) {
  //100,000
  // 1 2 3 5 8 13 21
  const fibonacci = [0, 1]

  for(let i = 2; i <= n; i++) {
    fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1234567
  }

  return fibonacci[n]
}

function runTests() {
  const testCases = [
    //3	2
    // 5	5
    { input: [3], expected: [2] },
    { input: [5], expected: [5] },
    { input: [1000], expected: [5] },
    { input: [100000], expected: [5] },
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
