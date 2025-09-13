// https://school.programmers.co.kr/learn/courses/30/lessons/12939
function solution(s) {
  const items = s.split(" ")
  const sortedItems = [...items.sort((a, b) => a - b)]

  return `${sortedItems[0]} ${sortedItems[items.length - 1]}`
}

function runTests() {
  const testCases = [
    { input: "1 2 3 4", expected: "1 4" },
    { input: "-1 -2 -3 -4", expected: "-4 -1" },
    { input: "-1 -1", expected: "-1 -1" },
  ];

  testCases.forEach((test, i) => {
    const result = solution(test.input);
    const passed = result === test.expected;
    console.log(`Test ${i + 1}: ${passed ? '✅' : '❌'}`);
    if (!passed) {
      console.log(`  Expected: ${test.expected}, Got: ${result}`);
    }
  });
}

runTests();
